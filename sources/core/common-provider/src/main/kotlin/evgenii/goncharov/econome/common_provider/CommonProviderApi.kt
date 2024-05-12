package evgenii.goncharov.econome.common_provider

import android.content.Context
import evgenii.goncharov.econome.common_provider.managers.ResourceManager

public interface CommonProviderApi {

    public fun provideAppContext(): Context

    public fun provideResourceManager(): ResourceManager
}