package evgenii.goncharov.econome.common.ui

import androidx.fragment.app.Fragment

public fun Fragment.requireArguments(key: String): String {
    val arg = requireArguments()
    val result = arg.getString(key) ?: throw IllegalArgumentException(ERROR_MESSAGE_ARG)
    return result
}

private const val ERROR_MESSAGE_ARG = "Argument is empty"