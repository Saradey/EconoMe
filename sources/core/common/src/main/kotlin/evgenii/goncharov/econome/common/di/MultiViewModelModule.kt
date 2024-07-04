package evgenii.goncharov.econome.common.di

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import evgenii.goncharov.econome.common.MultiViewModelFactory
import evgenii.goncharov.econome.di_core.di.qualifiers.CommonViewModelFactory
import evgenii.goncharov.econome.di_core.di.scopes.FeatureScope

@Module
public interface MultiViewModelModule {

    @CommonViewModelFactory
    @[Binds FeatureScope]
    public fun bindMultiViewModelFactory(factory: MultiViewModelFactory): ViewModelProvider.Factory
}