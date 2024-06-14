package evgenii.goncharov.econome.current_user.di.api

import evgenii.goncharov.econome.current_user.repositories.CurrentRepository

public interface CurrentApi {

    public fun provideCurrentUserRepository(): CurrentRepository
}