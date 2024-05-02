package evgenii.goncharov.econome.navigation.api

import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import evgenii.goncharov.econome.navigation.utils.DEEP_HOLDER
import evgenii.goncharov.econome.navigation.utils.DEEP_ROUTER
import evgenii.goncharov.econome.navigation.utils.GLOBAL_HOLDER
import evgenii.goncharov.econome.navigation.utils.GLOBAL_ROUTER
import javax.inject.Named

public interface CoreNavigationApi {

    @Named(GLOBAL_ROUTER)
    public fun provideGlobalRouter(): Router

    @Named(GLOBAL_HOLDER)
    public fun provideGlobalNavigatorHolder(): NavigatorHolder

    @Named(DEEP_ROUTER)
    public fun provideDeepRouter(): Router

    @Named(DEEP_HOLDER)
    public fun provideDeepNavigatorHolder(): NavigatorHolder
}