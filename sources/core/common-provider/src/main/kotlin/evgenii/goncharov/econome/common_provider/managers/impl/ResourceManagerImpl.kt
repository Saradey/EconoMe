package evgenii.goncharov.econome.common_provider.managers.impl

import android.content.Context
import androidx.annotation.StringRes
import evgenii.goncharov.econome.common_provider.managers.ResourceManager
import javax.inject.Inject

internal class ResourceManagerImpl @Inject constructor(
    private val appContext: Context
) : ResourceManager {

    override fun getString(@StringRes idString: Int): String {
        return appContext.getString(idString)
    }
}