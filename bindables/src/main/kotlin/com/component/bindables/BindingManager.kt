@file:Suppress("SpellCheckingInspection")

package com.component.bindables

import androidx.databinding.Bindable
import java.util.Locale
import kotlin.reflect.KFunction
import kotlin.reflect.KProperty
import kotlin.reflect.full.hasAnnotation

/**
 * A binding resource manager for providing proper DataBinding resources in the application.
 * This manager disassembles the `BR` class that generated by DataBinding process on compile time,
 * and uses those resources for providing proper binding information.
 */
public object BindingManager {

  /** A map for holding information of the generated fields in the BR class. */
  @PublishedApi
  internal var bindingFieldsMap: Map<String, Int> = emptyMap()

  /** Java Bean conventions for presenting a boolean. */
  private const val JAVA_BEANS_BOOLEAN: String = "is"

  /** Java Bean conventions for presenting a getter. */
  private const val JAVA_BEANS_GETTER: String = "get"

  /** Java Bean conventions for presenting a setter. */
  private const val JAVA_BEANS_SETTER: String = "set"

  /**
   * Binds the `BR` class into the [BindingManager].
   * This method only needs to be called once in the application.
   * The `BR` class will be disassembled by the [BindingManager], binding fields will be used
   * for finding the proper binding ID of properties.
   *
   * @param T The `BR` class that generated by the DataBinding processor.
   * @return The size of the stored fields.
   */
  public inline fun <reified T> bind(): Int {
    synchronized(this) {
      if (bindingFieldsMap.isNotEmpty()) return@synchronized
      bindingFieldsMap = BR::class.java.fields.asSequence()
        .map { it.name to it.getInt(null) }.toMap()
    }

    return bindingFieldsMap.size
  }

  /**
   * Returns proper binding ID by property.
   *
   * @param property A kotlin [androidx.databinding.Bindable] property for finding proper binding ID.
   */
  internal fun getBindingIdByProperty(property: KProperty<*>): Int {
    val bindingProperty = property.takeIf {
      it.getter.hasAnnotation<Bindable>()
    }
      ?: throw IllegalArgumentException("KProperty: ${property.name} must be annotated with the `@Bindable` annotation on the getter.")
    val propertyName = bindingProperty.name.replaceFirstChar { it.lowercase(Locale.ENGLISH) }
    val bindingPropertyName = propertyName
      .takeIf { it.startsWith(JAVA_BEANS_BOOLEAN) }
      ?.replaceFirst(JAVA_BEANS_BOOLEAN, String())
      ?.replaceFirstChar { it.lowercase(Locale.ENGLISH) } ?: propertyName
    return bindingFieldsMap[bindingPropertyName] ?: BR._all
  }

  /**
   * Returns proper binding ID by function.
   *
   * @param function A kotlin [androidx.databinding.Bindable] function for finding proper binding ID.
   */
  internal fun getBindingIdByFunction(function: KFunction<*>): Int {
    val bindingFunction = function.takeIf {
      it.hasAnnotation<Bindable>()
    }
      ?: throw IllegalArgumentException("KFunction: ${function.name} must be annotated with the `@Bindable` annotation.")
    val functionName = bindingFunction.name.replaceFirstChar { it.lowercase(Locale.ENGLISH) }
    val bindingFunctionName = when {
      functionName.startsWith(JAVA_BEANS_GETTER) -> functionName.replaceFirst(
        JAVA_BEANS_GETTER,
        String()
      )
      functionName.startsWith(JAVA_BEANS_SETTER) -> functionName.replaceFirst(
        JAVA_BEANS_SETTER,
        String()
      )
      functionName.startsWith(JAVA_BEANS_BOOLEAN) -> functionName.replaceFirst(
        JAVA_BEANS_BOOLEAN,
        String()
      )
      else -> throw IllegalArgumentException("@Bindable associated with method must follow JavaBeans convention $functionName")
    }.replaceFirstChar { it.lowercase(Locale.ENGLISH) }
    return bindingFieldsMap[bindingFunctionName] ?: BR._all
  }
}
