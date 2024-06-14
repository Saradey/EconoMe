package evgenii.goncharov.econome.current_user.di.modules

import dagger.Binds
import dagger.Module
import evgenii.goncharov.econome.current_user.repositories.CurrentUserRepository
import evgenii.goncharov.econome.current_user.repositories.CurrentWalletRepository
import evgenii.goncharov.econome.current_user.repositories.impl.CurrentUserRepositoryImpl
import evgenii.goncharov.econome.current_user.repositories.impl.CurrentWalletRepositoryImpl
import evgenii.goncharov.econome.di_core.di.scopes.CoreScope

@Module
internal interface CurrentBindsModule {

    @CoreScope
    @Binds
    fun bindCurrentRepository(manager: CurrentUserRepositoryImpl): CurrentUserRepository

    @CoreScope
    @Binds
    fun bindCurrentWalletRepository(manager: CurrentWalletRepositoryImpl): CurrentWalletRepository
}