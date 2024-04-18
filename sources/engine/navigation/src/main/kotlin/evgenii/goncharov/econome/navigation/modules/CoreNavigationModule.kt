package evgenii.goncharov.econome.navigation.modules

import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import dagger.Module
import dagger.Provides
import evgenii.goncharov.econome.di_core.di.scopes.CoreScope
import javax.inject.Named

@Module
internal object CoreNavigationModule {

    @[CoreScope Provides]
    fun provideCicerone(): Cicerone<Router> = Cicerone.create(Router())

    @[CoreScope Provides]
    fun provideRouter(cicerone: Cicerone<Router>): Router = cicerone.router

    @[CoreScope Provides]
    @Named("GlobalNavigatorHolder")
    fun provideHolder(cicerone: Cicerone<Router>): NavigatorHolder =
        cicerone.getNavigatorHolder()
}