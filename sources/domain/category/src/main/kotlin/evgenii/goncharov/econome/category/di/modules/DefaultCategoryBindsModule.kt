package evgenii.goncharov.econome.category.di.modules

import dagger.Binds
import dagger.Module
import evgenii.goncharov.econome.category.interactors.DefaultCategoryInteractor
import evgenii.goncharov.econome.category.interactors.impl.DefaultCategoryInteractorImpl
import evgenii.goncharov.econome.category.repositories.DefaultCategoryRepository
import evgenii.goncharov.econome.category.repositories.impl.DefaultCategoryRepositoryImpl
import evgenii.goncharov.econome.di_core.di.scopes.CoreScope

@Module
internal interface DefaultCategoryBindsModule {

    @Binds
    @CoreScope
    fun bindDefaultCategoryRepository(repository: DefaultCategoryRepositoryImpl): DefaultCategoryRepository

    @Binds
    @CoreScope
    fun bindDefaultCategoryInteractor(interactor: DefaultCategoryInteractorImpl): DefaultCategoryInteractor
}