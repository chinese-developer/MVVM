@file:Suppress("unused")
@file:JvmName("WhatIfActivity")
@file:JvmMultifileClass

package com.component.whatif.android

import android.app.Activity
import android.net.Uri
import android.os.Bundle
import android.os.Parcelable
import com.component.whatif.WhatIfInlineOnly
import com.component.whatif.whatIfNotNull
import com.component.whatif.whatIfNotNullAs
import java.io.Serializable
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/**
 * An expression for invoking [whatIf] when the [Activity]'s intent extras is not null and not empty.
 *
 * @param whatIf An executable lambda function if the [Activity]'s extra data is not null.
 */
@JvmSynthetic
@WhatIfInlineOnly
public inline fun Activity.whatIfHasExtras(
  whatIf: (Bundle) -> Unit,
) {
  contract {
    callsInPlace(whatIf, InvocationKind.AT_MOST_ONCE)
  }
  this.whatIfHasExtras(
    whatIf = whatIf,
    whatIfNot = { },
  )
}

/**
 * An expression for invoking [whatIf] when the [Activity]'s intent extras is not null and not empty.
 * If the intent extras is null or empty, [whatIfNot] will be invoked instead of the [whatIf].
 *
 * @param whatIf An executable lambda function if the [Activity]'s extra data is not null.
 * @param whatIfNot An executable lambda function if the [Activity]'s extra data is null.
 */
@JvmSynthetic
@WhatIfInlineOnly
public inline fun Activity.whatIfHasExtras(
  whatIf: (Bundle) -> Unit,
  whatIfNot: () -> Unit,
) {
  contract {
    callsInPlace(whatIf, InvocationKind.AT_MOST_ONCE)
    callsInPlace(whatIfNot, InvocationKind.AT_MOST_ONCE)
  }
  this.intent.extras.whatIfNotNull(
    whatIf = {
      if (!it.isEmpty) {
        whatIf(it)
      }
    },
    whatIfNot = { whatIfNot() },
  )
}

/**
 * An expression for invoking [whatIf] when the [Activity]'s intent extras is not null and not empty.
 *
 * @param name A given key related to an extra data.
 * @param whatIf An executable lambda function if the [Activity] has an extra data.
 */
@JvmSynthetic
@WhatIfInlineOnly
public inline fun Activity.whatIfHasExtras(
  name: String,
  whatIf: () -> Unit,
) {
  contract {
    callsInPlace(whatIf, InvocationKind.AT_MOST_ONCE)
  }
  this.whatIfHasExtras(
    name = name,
    whatIf = whatIf,
    whatIfNot = { },
  )
}

/**
 * An expression for invoking [whatIf] when the [Activity]'s intent extras is not null and not empty.
 * If the intent extras is null or empty, [whatIfNot] will be invoked instead of the [whatIf].
 *
 * @param name A given key related to an extra data.
 * @param whatIf An executable lambda function if the [Activity] has an extra data.
 * @param whatIfNot An executable lambda function if the [Activity] has not an extra data.
 */
@JvmSynthetic
@WhatIfInlineOnly
public inline fun Activity.whatIfHasExtras(
  name: String,
  whatIf: () -> Unit,
  whatIfNot: () -> Unit,
) {
  contract {
    callsInPlace(whatIf, InvocationKind.AT_MOST_ONCE)
    callsInPlace(whatIfNot, InvocationKind.AT_MOST_ONCE)
  }
  if (intent.hasExtra(name)) {
    whatIf()
  } else {
    whatIfNot()
  }
}

/**
 * An expression for invoking [whatIf] when the [Activity]'s intent extras is has a string extra by name.
 *
 * @param name A given key related to an extra data.
 * @param whatIf An executable lambda function if the [Activity] has an string extra data.
 */
@JvmSynthetic
@WhatIfInlineOnly
public inline fun Activity.whatIfHasStringExtra(
  name: String,
  whatIf: (String) -> Unit,
) {
  contract {
    callsInPlace(whatIf, InvocationKind.AT_MOST_ONCE)
  }
  this.intent.getStringExtra(name).whatIfNotNull(
    whatIf = whatIf,
    whatIfNot = { },
  )
}

/**
 * An expression for invoking [whatIf] when the [Activity]'s intent extras is has a string extra by name.
 * If the intent extras is null, [whatIfNot] will be invoked instead of the [whatIf].
 *
 * @param name A given key related to an extra data.
 * @param whatIf An executable lambda function if the [Activity] has an string extra data.
 * @param whatIfNot An executable lambda function if the [Activity] has not an string extra data.
 */
@JvmSynthetic
@WhatIfInlineOnly
public inline fun Activity.whatIfHasStringExtra(
  name: String,
  whatIf: (String) -> Unit,
  whatIfNot: () -> Unit,
) {
  contract {
    callsInPlace(whatIf, InvocationKind.AT_MOST_ONCE)
    callsInPlace(whatIfNot, InvocationKind.AT_MOST_ONCE)
  }
  this.intent.getStringExtra(name).whatIfNotNull(
    whatIf = whatIf,
    whatIfNot = whatIfNot,
  )
}

/**
 * An expression for invoking [whatIf] when the [Activity]'s intent extras is has a CharSequence extra by name.
 *
 * @param name A given key related to an extra data.
 * @param whatIf An executable lambda function if the [Activity] has an charSequence extra data.
 */
@JvmSynthetic
@WhatIfInlineOnly
public inline fun Activity.whatIfHasCharSequenceExtra(
  name: String,
  whatIf: (CharSequence) -> Unit,
) {
  contract {
    callsInPlace(whatIf, InvocationKind.AT_MOST_ONCE)
  }
  this.intent.getCharSequenceExtra(name).whatIfNotNull(
    whatIf = whatIf,
    whatIfNot = { },
  )
}

/**
 * An expression for invoking [whatIf] when the[Activity]'s intent extras is has a CharSequence extra by name.
 * If the intent extras is null, [whatIfNot] will be invoked instead of the [whatIf].
 *
 * @param name A given key related to an extra data.
 * @param whatIf An executable lambda function if the [Activity] has an charSequence extra data.
 * @param whatIfNot An executable lambda function if the [Activity] has not an charSequence extra data.
 */
@JvmSynthetic
@WhatIfInlineOnly
public inline fun Activity.whatIfHasCharSequenceExtra(
  name: String,
  whatIf: (CharSequence) -> Unit,
  whatIfNot: () -> Unit,
) {
  contract {
    callsInPlace(whatIf, InvocationKind.AT_MOST_ONCE)
    callsInPlace(whatIfNot, InvocationKind.AT_MOST_ONCE)
  }
  this.intent.getCharSequenceExtra(name).whatIfNotNull(
    whatIf = whatIf,
    whatIfNot = whatIfNot,
  )
}

/**
 * An expression for invoking [whatIf] when the [Activity]'s intent extras is has a Serializable extra by name.
 *
 * @param name A given key related to an extra data.
 * @param whatIf An executable lambda function if the [Activity] has a serializable extra data.
 */
@JvmSynthetic
@WhatIfInlineOnly
public inline fun <reified T : Serializable> Activity.whatIfHasSerializableExtra(
  name: String,
  whatIf: (T) -> Unit,
) {
  contract {
    callsInPlace(whatIf, InvocationKind.AT_MOST_ONCE)
  }
  if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.TIRAMISU) {
    this.intent.getSerializableExtra(name, T::class.java).whatIfNotNullAs(
      whatIf = whatIf,
      whatIfNot = { },
    )
  } else {
    @Suppress("DEPRECATION")
    (this.intent.getSerializableExtra(name) as? T).whatIfNotNullAs(
      whatIf = whatIf,
      whatIfNot = { },
    )
  }
}

/**
 * An expression for invoking [whatIf] when the[Activity]'s intent extras is has a Serializable extra by name.
 * If the intent extras is null, [whatIfNot] will be invoked instead of the [whatIf].
 *
 * @param name A given key related to an extra data.
 * @param whatIf An executable lambda function if the [Activity] has a serializable extra data.
 * @param whatIfNot An executable lambda function if the [Activity] has not a serializable extra data.
 */
@JvmSynthetic
@WhatIfInlineOnly
public inline fun <reified T : Serializable> Activity.whatIfHasSerializableExtra(
  name: String,
  whatIf: (T) -> Unit,
  whatIfNot: () -> Unit,
) {
  contract {
    callsInPlace(whatIf, InvocationKind.AT_MOST_ONCE)
    callsInPlace(whatIfNot, InvocationKind.AT_MOST_ONCE)
  }
  if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.TIRAMISU) {
    this.intent.getSerializableExtra(name, T::class.java).whatIfNotNullAs(
      whatIf = whatIf,
      whatIfNot = whatIfNot,
    )
  } else {
    @Suppress("DEPRECATION")
    (this.intent.getSerializableExtra(name) as? T).whatIfNotNullAs(
      whatIf = whatIf,
      whatIfNot = whatIfNot,
    )
  }
}

/**
 * An expression for invoking [whatIf] when the [Activity]'s intent extras is has an object extra by name.
 *
 * @param name A given key related to an extra data.
 * @param whatIf An executable lambda function if the [Activity] has a parcelable extra data.
 */
@JvmSynthetic
@WhatIfInlineOnly
public inline fun <reified T : Parcelable> Activity.whatIfHasParcelableExtra(
  name: String,
  whatIf: (T) -> Unit,
) {
  contract {
    callsInPlace(whatIf, InvocationKind.AT_MOST_ONCE)
  }
  if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.TIRAMISU) {
    this.intent.getParcelableExtra(name, T::class.java).whatIfNotNull(
      whatIf = whatIf,
      whatIfNot = { },
    )
  } else {
    @Suppress("DEPRECATION")
    this.intent.getParcelableExtra<T>(name).whatIfNotNull(
      whatIf = whatIf,
      whatIfNot = { },
    )
  }
}

/**
 * An expression for invoking [whatIf] when the[Activity]'s intent extras is has an object extra by name.
 * If the intent extras is null, [whatIfNot] will be invoked instead of the [whatIf].
 *
 * @param name A given key related to an extra data.
 * @param whatIf An executable lambda function if the [Activity] has a parcelable extra data.
 * @param whatIfNot An executable lambda function if the [Activity] has not a parcelable extra data.
 */
@JvmSynthetic
@WhatIfInlineOnly
public inline fun <reified T : Parcelable> Activity.whatIfHasParcelableExtra(
  name: String,
  whatIf: (T) -> Unit,
  whatIfNot: () -> Unit,
) {
  contract {
    callsInPlace(whatIf, InvocationKind.AT_MOST_ONCE)
    callsInPlace(whatIfNot, InvocationKind.AT_MOST_ONCE)
  }
  if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.TIRAMISU) {
    this.intent.getParcelableExtra(name, T::class.java).whatIfNotNull(
      whatIf = whatIf,
      whatIfNot = whatIfNot,
    )
  } else {
    @Suppress("DEPRECATION")
    this.intent.getParcelableExtra<T>(name).whatIfNotNull(
      whatIf = whatIf,
      whatIfNot = whatIfNot,
    )
  }
}

/**
 * An expression for invoking [whatIf] when the [Activity]'s intent extras is has an ArrayList of object extra by name.
 *
 * @param name A given key related to an extra data.
 * @param whatIf An executable lambda function if the [Activity] has a parcelable array list extra data.
 */
@JvmSynthetic
@WhatIfInlineOnly
public inline fun <reified T : Parcelable> Activity.whatIfHasParcelableArrayListExtra(
  name: String,
  whatIf: (ArrayList<T>) -> Unit,
) {
  contract {
    callsInPlace(whatIf, InvocationKind.AT_MOST_ONCE)
  }
  if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.TIRAMISU) {
    this.intent.getParcelableArrayListExtra(name, T::class.java).whatIfNotNull(
      whatIf = whatIf,
      whatIfNot = { },
    )
  } else {
    @Suppress("DEPRECATION")
    this.intent.getParcelableArrayListExtra<T>(name).whatIfNotNull(
      whatIf = whatIf,
      whatIfNot = { },
    )
  }
}

/**
 * An expression for invoking [whatIf] when the [Activity]'s intent extras is has an ArrayList of object extra by name.
 * If the intent extras is null, [whatIfNot] will be invoked instead of the [whatIf].
 *
 * @param name A given key related to an extra data.
 * @param whatIf An executable lambda function if the [Activity] has a parcelable array list extra data.
 * @param whatIfNot An executable lambda function if the [Activity] has not a parcelable array list extra data.
 */
@JvmSynthetic
@WhatIfInlineOnly
public inline fun <reified T : Parcelable> Activity.whatIfHasParcelableArrayListExtra(
  name: String,
  whatIf: (ArrayList<T>) -> Unit,
  whatIfNot: () -> Unit,
) {
  contract {
    callsInPlace(whatIf, InvocationKind.AT_MOST_ONCE)
    callsInPlace(whatIfNot, InvocationKind.AT_MOST_ONCE)
  }
  if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.TIRAMISU) {
    this.intent.getParcelableArrayListExtra(name, T::class.java).whatIfNotNull(
      whatIf = whatIf,
      whatIfNot = whatIfNot,
    )
  } else {
    @Suppress("DEPRECATION")
    this.intent.getParcelableArrayListExtra<T>(name).whatIfNotNull(
      whatIf = whatIf,
      whatIfNot = whatIfNot,
    )
  }
}

/**
 * An expression for invoking [whatIf] when the [Activity]'s intent deep link uri is not null and not empty.
 *
 * @param whatIf An executable lambda function if the [Activity]'s extra data is not null.
 */
@JvmSynthetic
@WhatIfInlineOnly
public inline fun Activity.whatIfHasDeepLinkUri(
  whatIf: (Uri) -> Unit,
) {
  contract {
    callsInPlace(whatIf, InvocationKind.AT_MOST_ONCE)
  }
  this.whatIfHasDeepLinkUri(whatIf) { }
}

/**
 * An expression for invoking [whatIf] when the [Activity]'s intent deep link uri is not null and not empty.
 * If the intent deep link uri is null or empty, [whatIfNot] will be invoked instead of the [whatIf].
 *
 * @param whatIf An executable lambda function if the [Activity]'s deep link uri is not null.
 * @param whatIfNot An executable lambda function if the [Activity]'s deep link uri is null.
 */
@JvmSynthetic
@WhatIfInlineOnly
public inline fun Activity.whatIfHasDeepLinkUri(
  whatIf: (Uri) -> Unit,
  whatIfNot: () -> Unit,
) {
  contract {
    callsInPlace(whatIf, InvocationKind.AT_MOST_ONCE)
    callsInPlace(whatIfNot, InvocationKind.AT_MOST_ONCE)
  }
  this.intent.data.whatIfNotNull(whatIf, whatIfNot)
}
