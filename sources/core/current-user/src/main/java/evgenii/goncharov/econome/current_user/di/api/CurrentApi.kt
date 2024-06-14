package evgenii.goncharov.econome.current_user.di.api

import evgenii.goncharov.econome.current_user.repositories.CurrentUserRepository
import evgenii.goncharov.econome.current_user.repositories.CurrentWalletRepository

public interface CurrentApi {

    public fun provideCurrentUserRepository(): CurrentUserRepository

    public fun provideCurrentWalletRepository(): CurrentWalletRepository
}