package evgenii.goncharov.econome.current_user.di.modules

import dagger.Binds
import dagger.Module
import evgenii.goncharov.econome.current_user.repositories.CurrentRepository
import evgenii.goncharov.econome.current_user.repositories.impl.CurrentRepositoryImpl
import evgenii.goncharov.econome.di_core.di.scopes.CoreScope

@Module
internal interface CurrentBindsModule {

    @CoreScope
    @Binds
    fun bindCurrentRepository(manager: CurrentRepositoryImpl): CurrentRepository
}