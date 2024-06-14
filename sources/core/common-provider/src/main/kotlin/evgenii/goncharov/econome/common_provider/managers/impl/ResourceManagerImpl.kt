package evgenii.goncharov.econome.common_provider.managers.impl

import android.content.Context
import androidx.annotation.RawRes
import androidx.annotation.StringRes
import evgenii.goncharov.econome.common_provider.managers.ResourceManager
import java.io.InputStream
import javax.inject.Inject

internal class ResourceManagerImpl @Inject constructor(
    private val appContext: Context
) : ResourceManager {

    override fun getString(@StringRes idString: Int): String {
        return appContext.getString(idString)
    }

    override fun getRawFile(@RawRes idRes: Int): InputStream {
        return appContext.resources.openRawResource(idRes)
    }
}