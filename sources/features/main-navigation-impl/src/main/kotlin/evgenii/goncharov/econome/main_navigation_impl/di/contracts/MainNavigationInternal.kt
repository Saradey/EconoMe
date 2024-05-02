package evgenii.goncharov.econome.main_navigation_impl.di.contracts

import androidx.activity.OnBackPressedCallback
import evgenii.goncharov.econome.main_navigation.di.MainNavigationApi
import evgenii.goncharov.econome.navigation.api.CoreNavigationApi

internal interface MainNavigationInternal : MainNavigationApi, CoreNavigationApi {

    fun provideMainNavigation(): OnBackPressedCallback
}