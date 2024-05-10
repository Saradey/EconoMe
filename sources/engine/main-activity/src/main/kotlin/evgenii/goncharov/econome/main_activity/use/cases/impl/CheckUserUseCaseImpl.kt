package evgenii.goncharov.econome.main_activity.use.cases.impl

import evgenii.goncharov.econome.main_activity.repositories.MainActivityRepository
import evgenii.goncharov.econome.main_activity.use.cases.CheckUserUseCase
import javax.inject.Inject

internal class CheckUserUseCaseImpl @Inject constructor(
    private val mainActivityRepository: MainActivityRepository
) : CheckUserUseCase {

    override fun checkUser() {

    }
}