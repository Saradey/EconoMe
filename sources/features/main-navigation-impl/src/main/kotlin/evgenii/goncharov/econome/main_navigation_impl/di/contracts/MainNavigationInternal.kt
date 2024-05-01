package evgenii.goncharov.econome.main_navigation_impl.di.contracts

import evgenii.goncharov.econome.main_navigation.di.MainNavigationApi
import evgenii.goncharov.econome.main_navigation_impl.di.modules.MainNavigationBindsModule
import evgenii.goncharov.econome.navigation.api.CoreNavigationApi

internal interface MainNavigationInternal : MainNavigationApi, CoreNavigationApi {

    fun provideMainNavigation(): MainNavigationBindsModule
}