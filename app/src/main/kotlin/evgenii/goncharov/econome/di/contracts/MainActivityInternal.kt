package evgenii.goncharov.econome.di.contracts

import androidx.lifecycle.ViewModelProvider
import evgenii.goncharov.econome.navigation.api.CoreNavigationApi

interface MainActivityInternal : MainActivityApi, CoreNavigationApi {

    fun provideViewModelFactory(): ViewModelProvider.Factory
}