package evgenii.goncharov.econome.navigation.modules

import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import dagger.Module
import dagger.Provides
import evgenii.goncharov.econome.di_core.di.scopes.CoreScope
import evgenii.goncharov.econome.navigation.utils.DEEP_CICERONE
import evgenii.goncharov.econome.navigation.utils.DEEP_HOLDER
import evgenii.goncharov.econome.navigation.utils.DEEP_ROUTER
import evgenii.goncharov.econome.navigation.utils.GLOBAL_CICERONE
import evgenii.goncharov.econome.navigation.utils.GLOBAL_HOLDER
import evgenii.goncharov.econome.navigation.utils.GLOBAL_ROUTER
import javax.inject.Named

@Module
internal object CoreNavigationModule {

    @[CoreScope Provides]
    @Named(GLOBAL_CICERONE)
    fun provideGlobalCicerone(): Cicerone<Router> = Cicerone.create(Router())

    @[CoreScope Provides]
    @Named(GLOBAL_ROUTER)
    fun provideGlobalRouter(@Named(GLOBAL_CICERONE) cicerone: Cicerone<Router>): Router =
        cicerone.router

    @[CoreScope Provides]
    @Named(GLOBAL_HOLDER)
    fun provideGlobalHolder(@Named(GLOBAL_CICERONE) cicerone: Cicerone<Router>): NavigatorHolder =
        cicerone.getNavigatorHolder()

    @[CoreScope Provides]
    @Named(DEEP_CICERONE)
    fun provideDeepCicerone(): Cicerone<Router> = Cicerone.create(Router())

    @[CoreScope Provides]
    @Named(DEEP_ROUTER)
    fun provideDeepRouter(@Named(DEEP_ROUTER) cicerone: Cicerone<Router>): Router = cicerone.router

    @[CoreScope Provides]
    @Named(DEEP_HOLDER)
    fun provideDeepHolder(@Named(DEEP_ROUTER) cicerone: Cicerone<Router>): NavigatorHolder =
        cicerone.getNavigatorHolder()
}