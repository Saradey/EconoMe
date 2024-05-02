package evgenii.goncharov.econome.main_navigation_impl.di.modules

import androidx.activity.OnBackPressedCallback
import dagger.Binds
import dagger.Module
import evgenii.goncharov.econome.di_core.di.scopes.FeatureScope
import evgenii.goncharov.econome.main_navigation_impl.navigation.BottomMenuOnBackPressed

@Module
internal interface MainNavigationBindsModule {

    @FeatureScope
    @Binds
    fun bindBottomMenuOnBackPressed(onBackPressed: BottomMenuOnBackPressed): OnBackPressedCallback
}