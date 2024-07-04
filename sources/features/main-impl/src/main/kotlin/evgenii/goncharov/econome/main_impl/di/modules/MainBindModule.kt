package evgenii.goncharov.econome.main_impl.di.modules

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import evgenii.goncharov.econome.common.di.MultiViewModelModule
import evgenii.goncharov.econome.di_core.di.keys.ViewModelKey
import evgenii.goncharov.econome.di_core.di.scopes.FeatureScope
import evgenii.goncharov.econome.main_api.dependencies.MainDataRefresher
import evgenii.goncharov.econome.main_impl.dependencies.MainDataRefresherImpl
import evgenii.goncharov.econome.main_impl.interactors.MainInteractor
import evgenii.goncharov.econome.main_impl.interactors.impl.MainInteractorImpl
import evgenii.goncharov.econome.main_impl.repositories.MainRepository
import evgenii.goncharov.econome.main_impl.repositories.impl.MainRepositoryImpl
import evgenii.goncharov.econome.main_impl.view.models.MainViewModel

@Module(includes = [MultiViewModelModule::class])
internal interface MainBindModule {

    @[Binds FeatureScope]
    @[IntoMap ViewModelKey(MainViewModel::class)]
    fun bindMainViewModel(viewModel: MainViewModel): ViewModel

    @Binds
    @FeatureScope
    fun bindMainInteractor(interactor: MainInteractorImpl): MainInteractor

    @Binds
    @FeatureScope
    fun bindMainRepository(repository: MainRepositoryImpl): MainRepository

    @Binds
    @FeatureScope
    fun bindMainDataRefresher(mainDataRefresher: MainDataRefresherImpl) : MainDataRefresher
}