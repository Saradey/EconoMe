package evgenii.goncharov.econome.finance_analysis_impl.di.modules

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import evgenii.goncharov.econome.common.di.MultiViewModelModule
import evgenii.goncharov.econome.di_core.di.keys.ViewModelKey
import evgenii.goncharov.econome.di_core.di.scopes.FeatureScope
import evgenii.goncharov.econome.finance_analysis_impl.view.models.FinanceAnalyticsViewModel

@Module(includes = [MultiViewModelModule::class])
internal interface FinanceAnalyticsBindsModule {

    @[Binds FeatureScope]
    @[IntoMap ViewModelKey(FinanceAnalyticsViewModel::class)]
    fun bindFinanceAnalyticsViewModel(viewModel: FinanceAnalyticsViewModel): ViewModel
}