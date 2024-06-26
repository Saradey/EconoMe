package evgenii.goncharov.econome.wallet_impl.di.modules

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import evgenii.goncharov.econome.common.di.MultiViewModelModule
import evgenii.goncharov.econome.di_core.di.keys.ViewModelKey
import evgenii.goncharov.econome.di_core.di.scopes.FeatureScope
import evgenii.goncharov.econome.wallet_impl.repositories.WalletCreatorRepository
import evgenii.goncharov.econome.wallet_impl.repositories.impl.WalletCreatorRepositoryImpl
import evgenii.goncharov.econome.wallet_impl.view.models.WalletCreatorViewModel

@Module(includes = [MultiViewModelModule::class])
internal interface WalletCreatorModule {

    @[Binds FeatureScope]
    @[IntoMap ViewModelKey(WalletCreatorViewModel::class)]
    fun bindWalletCreatorViewModel(viewModel: WalletCreatorViewModel): ViewModel

    @[Binds FeatureScope]
    fun bindWalletCreatorRepository(rep: WalletCreatorRepositoryImpl): WalletCreatorRepository
}