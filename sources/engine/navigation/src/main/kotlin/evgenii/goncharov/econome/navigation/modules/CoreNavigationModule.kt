package evgenii.goncharov.econome.navigation.modules

import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import dagger.Module
import dagger.Provides
import evgenii.goncharov.econome.di_core.di.scopes.CoreScope
import evgenii.goncharov.econome.navigation.utils.GLOBAL_HOLDER
import evgenii.goncharov.econome.navigation.utils.GLOBAL_ROUTER
import javax.inject.Named

@Module
internal object CoreNavigationModule {

    @[CoreScope Provides]
    fun provideCicerone(): Cicerone<Router> = Cicerone.create(Router())

    @[CoreScope Provides]
    @Named(GLOBAL_ROUTER)
    fun provideRouter(cicerone: Cicerone<Router>): Router = cicerone.router

    @[CoreScope Provides]
    @Named(GLOBAL_HOLDER)
    fun provideHolder(cicerone: Cicerone<Router>): NavigatorHolder =
        cicerone.getNavigatorHolder()
}