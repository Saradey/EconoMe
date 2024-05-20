package evgenii.goncharov.econome.main_activity.use.cases

import evgenii.goncharov.econome.main_activity.models.CheckUserModel

internal fun interface CheckUserUseCase {

    suspend operator fun invoke(): CheckUserModel
}