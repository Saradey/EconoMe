package evgenii.goncharov.econome.main_impl.interactors

import evgenii.goncharov.econome.main_impl.models.CurrentUserModel

internal interface MainInteractor {

    fun checkParameters()

    suspend fun formCurrentUser(): CurrentUserModel
}