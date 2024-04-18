package evgenii.goncharov.econome.navigation

import com.github.terrakok.cicerone.NavigatorHolder
import javax.inject.Named

public interface CoreNavigationApi {

//    public fun provideGlobalRouter(): GlobalRouter

    @Named("GlobalNavigatorHolder")
    public fun provideGlobalNavigatorHolder(): NavigatorHolder
}