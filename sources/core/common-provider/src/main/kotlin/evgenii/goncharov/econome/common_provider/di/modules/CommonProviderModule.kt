package evgenii.goncharov.econome.common_provider.di.modules

import android.content.Context
import dagger.Module
import dagger.Provides
import evgenii.goncharov.econome.di_core.di.scopes.CoreScope
import kotlinx.serialization.json.Json
import java.util.Locale

@Module
internal object CommonProviderModule {

    @Provides
    @CoreScope
    fun provideJson(): Json = Json { ignoreUnknownKeys = true }

    @Provides
    @CoreScope
    fun provideLocale(appContext: Context): Locale {
        return appContext.resources.configuration.locales[0]
    }
}