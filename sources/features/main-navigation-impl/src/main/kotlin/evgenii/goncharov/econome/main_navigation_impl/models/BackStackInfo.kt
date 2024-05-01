package evgenii.goncharov.econome.main_navigation_impl.models

import android.os.Parcelable
import java.util.Stack
import kotlinx.parcelize.Parcelize

@Parcelize
internal data class BackStackInfo(
    val backStackName: String, val screensKey: Stack<String>
) : Parcelable