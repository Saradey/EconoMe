package evgenii.goncharov.econome.spending_impl.di.modules

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import evgenii.goncharov.econome.di_core.di.scopes.FeatureScope
import evgenii.goncharov.econome.spending_impl.di.assisted.SpendingInfoViewModelProviderFactory
import evgenii.goncharov.econome.spending_impl.repositories.SpendingInfoRepository
import evgenii.goncharov.econome.spending_impl.repositories.impl.SpendingInfoRepositoryImpl

@Module
internal interface SpendingInfoBindModule {

    @Binds
    @FeatureScope
    fun bindSpendingInfoViewModelProviderFactory(
        factory: SpendingInfoViewModelProviderFactory
    ): ViewModelProvider.Factory

    @Binds
    @FeatureScope
    fun bindSpendingInfoRepository(repository: SpendingInfoRepositoryImpl) : SpendingInfoRepository
}