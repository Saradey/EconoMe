package evgenii.goncharov.econome.bank_accounts_impl.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import evgenii.goncharov.econome.bank_accounts_impl.view.models.BankAccountsViewModel
import evgenii.goncharov.econome.common.MultiViewModelFactory
import evgenii.goncharov.econome.di_core.di.keys.ViewModelKey
import evgenii.goncharov.econome.di_core.di.scopes.FeatureScope

@Module
internal interface BankAccountsViewModelBindsModule {

    @[Binds FeatureScope]
    fun bindMultiViewModelFactory(factory: MultiViewModelFactory): ViewModelProvider.Factory

    @[Binds FeatureScope]
    @[IntoMap ViewModelKey(BankAccountsViewModel::class)]
    fun bindBankAccountsViewModel(viewModel: BankAccountsViewModel): ViewModel
}