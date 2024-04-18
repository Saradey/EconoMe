package evgenii.goncharov.econome.di.modules

import dagger.Module
import dagger.Provides
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
import evgenii.goncharov.econome.di_core.contracts.BaseLauncher
import javax.inject.Singleton

@Module
object LauncherModule {

    @Provides
    @[Singleton IntoMap ClassKey(BaseLauncher::class)]
    fun provideBalanceHistoryLauncher(): BaseLauncher {
        return object : BaseLauncher {}
    }
}