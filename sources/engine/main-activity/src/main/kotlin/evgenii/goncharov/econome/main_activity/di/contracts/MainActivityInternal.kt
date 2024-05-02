package evgenii.goncharov.econome.main_activity.di.contracts

import androidx.activity.OnBackPressedCallback
import evgenii.goncharov.econome.navigation.api.CoreNavigationApi

internal interface MainActivityInternal : MainActivityApi, CoreNavigationApi {

    fun provideOnBackPressedCallback(): OnBackPressedCallback
}