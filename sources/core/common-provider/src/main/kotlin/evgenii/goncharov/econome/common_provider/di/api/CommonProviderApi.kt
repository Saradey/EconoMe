package evgenii.goncharov.econome.common_provider.di.api

import android.content.Context
import evgenii.goncharov.econome.common_provider.managers.AuthManager
import evgenii.goncharov.econome.common_provider.managers.ResourceManager
import kotlinx.serialization.json.Json
import java.util.Locale

public interface CommonProviderApi {

    public fun provideAppContext(): Context

    public fun provideResourceManager(): ResourceManager

    public fun provideAuthManager(): AuthManager

    public fun provideCommonJsonDecoder() : Json

    public fun provideLocale() : Locale
}