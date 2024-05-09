package evgenii.goncharov.econome.main_impl.di.modules

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import evgenii.goncharov.econome.common.di.MultiViewModelModule
import evgenii.goncharov.econome.di_core.di.keys.ViewModelKey
import evgenii.goncharov.econome.di_core.di.scopes.FeatureScope
import evgenii.goncharov.econome.main_impl.view.models.SpendingLimitViewModel

@Module(includes = [MultiViewModelModule::class])
internal interface SpendingLimitBindModule {

    @[Binds FeatureScope]
    @[IntoMap ViewModelKey(SpendingLimitViewModel::class)]
    fun bindSpendingLimitViewModel(viewModel: SpendingLimitViewModel): ViewModel
}