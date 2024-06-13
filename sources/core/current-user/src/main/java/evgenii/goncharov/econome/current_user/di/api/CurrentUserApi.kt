package evgenii.goncharov.econome.current_user.di.api

import evgenii.goncharov.econome.current_user.repositories.CurrentUserRepository

public interface CurrentUserApi {

    public fun provideCurrentUserRepository(): CurrentUserRepository
}