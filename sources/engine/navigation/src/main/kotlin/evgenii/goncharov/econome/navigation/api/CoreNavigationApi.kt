package evgenii.goncharov.econome.navigation.api

import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import evgenii.goncharov.econome.navigation.utils.GLOBAL_HOLDER
import evgenii.goncharov.econome.navigation.utils.GLOBAL_ROUTER
import javax.inject.Named

public interface CoreNavigationApi {

    @Named(GLOBAL_ROUTER)
    public fun provideGlobalRouter(): Router

    @Named(GLOBAL_HOLDER)
    public fun provideGlobalNavigatorHolder(): NavigatorHolder
}