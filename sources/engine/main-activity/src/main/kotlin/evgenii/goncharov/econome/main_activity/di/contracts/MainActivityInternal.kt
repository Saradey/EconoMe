package evgenii.goncharov.econome.main_activity.di.contracts

import androidx.lifecycle.ViewModelProvider
import evgenii.goncharov.econome.navigation.api.CoreNavigationApi

internal interface MainActivityInternal : MainActivityApi, CoreNavigationApi {

    fun provideViewModelFactory(): ViewModelProvider.Factory
}