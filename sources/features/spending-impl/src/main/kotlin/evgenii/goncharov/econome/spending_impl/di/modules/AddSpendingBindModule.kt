package evgenii.goncharov.econome.spending_impl.di.modules

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import evgenii.goncharov.econome.common.di.MultiViewModelModule
import evgenii.goncharov.econome.di_core.di.keys.ViewModelKey
import evgenii.goncharov.econome.di_core.di.scopes.FeatureScope
import evgenii.goncharov.econome.spending_impl.interactors.AddSpendingInteractor
import evgenii.goncharov.econome.spending_impl.interactors.impl.AddSpendingInteractorImpl
import evgenii.goncharov.econome.spending_impl.repositories.AddSpendingRepository
import evgenii.goncharov.econome.spending_impl.repositories.impl.AddSpendingRepositoryImpl
import evgenii.goncharov.econome.spending_impl.use.cases.InputSpendingValidatorUseCase
import evgenii.goncharov.econome.spending_impl.use.cases.impl.InputSpendingValidatorUseCaseImpl
import evgenii.goncharov.econome.spending_impl.view.models.AddSpendingViewModel

@Module(includes = [MultiViewModelModule::class])
internal interface AddSpendingBindModule {

    @[Binds FeatureScope]
    @[IntoMap ViewModelKey(AddSpendingViewModel::class)]
    fun bindAddSpendingViewModel(viewModel: AddSpendingViewModel): ViewModel

    @Binds
    @FeatureScope
    fun bindInputSpendingValidatorUseCase(
        useCase: InputSpendingValidatorUseCaseImpl
    ): InputSpendingValidatorUseCase

    @Binds
    @FeatureScope
    fun bindAddSpendingInteractor(interactor: AddSpendingInteractorImpl): AddSpendingInteractor

    @Binds
    @FeatureScope
    fun bindAddSpendingRepository(repository: AddSpendingRepositoryImpl): AddSpendingRepository
}