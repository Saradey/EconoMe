package evgenii.goncharov.econome.core_dependencies_impl

import android.content.Context
import evgenii.goncharov.econome.core_dependencies_api.ResourceManager
import javax.inject.Inject

public class ResourceManagerImpl @Inject constructor(
    private val appContext: Context
) : ResourceManager {

}