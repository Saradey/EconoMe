package evgenii.goncharov.econome.finance_analysis_impl.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import evgenii.goncharov.econome.common.MultiViewModelFactory
import evgenii.goncharov.econome.di_core.di.keys.ViewModelKey
import evgenii.goncharov.econome.di_core.di.scopes.FeatureScope
import evgenii.goncharov.econome.finance_analysis_impl.view.models.FinanceAnalyticsAllSpendingViewModel

@Module
internal interface FinanceAnalyticsAllSpendingViewModelBindsModule {

    @[Binds FeatureScope]
    fun bindMultiViewModelFactory(factory: MultiViewModelFactory): ViewModelProvider.Factory

    @[Binds FeatureScope]
    @[IntoMap ViewModelKey(FinanceAnalyticsAllSpendingViewModel::class)]
    fun bindFinanceAnalyticsAllSpendingViewModel(viewModel: FinanceAnalyticsAllSpendingViewModel): ViewModel
}