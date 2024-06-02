package evgenii.goncharov.econome.common.ui

import androidx.fragment.app.Fragment
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

internal class StringArgumentDelegate(
    private val fragment: Fragment,
    private val key: String
) : ReadOnlyProperty<Fragment, String> {

    override fun getValue(thisRef: Fragment, property: KProperty<*>): String {
        return fragment.arguments?.getString(key)
            ?: throw IllegalArgumentException("Argument $key is missing")
    }
}

public fun Fragment.requireStringArguments(key: String): ReadOnlyProperty<Fragment, String> {
    return StringArgumentDelegate(this, key)
}