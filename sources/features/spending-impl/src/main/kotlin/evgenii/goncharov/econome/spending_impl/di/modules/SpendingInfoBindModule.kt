package evgenii.goncharov.econome.spending_impl.di.modules

import androidx.lifecycle.ViewModelProvider
import dagger.Module
import dagger.Provides
import evgenii.goncharov.econome.di_core.di.scopes.FeatureScope
import evgenii.goncharov.econome.spending_impl.di.assisted.SpendingInfoViewModelProviderFactory
import evgenii.goncharov.econome.spending_impl.view.models.SpendingInfoViewModel

@Module
internal object SpendingInfoBindModule {

    @FeatureScope
    @Provides
    fun provideSpendingInfoViewModelProviderFactory(
        factory: SpendingInfoViewModel.Factory,
        spendingId: Long
    ): ViewModelProvider.Factory {
        return SpendingInfoViewModelProviderFactory(factory, spendingId)
    }
}