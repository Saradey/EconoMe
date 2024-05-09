package evgenii.goncharov.econome.bank_accounts_impl.di.modules

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import evgenii.goncharov.econome.bank_accounts_impl.view.models.AddStateAccountViewModel
import evgenii.goncharov.econome.common.di.MultiViewModelModule
import evgenii.goncharov.econome.di_core.di.keys.ViewModelKey
import evgenii.goncharov.econome.di_core.di.scopes.FeatureScope

@Module(includes = [MultiViewModelModule::class])
internal interface AddStateAccountBindModule {

    @[Binds FeatureScope]
    @[IntoMap ViewModelKey(AddStateAccountViewModel::class)]
    fun bindAddStateAccountViewModel(viewModel: AddStateAccountViewModel): ViewModel
}