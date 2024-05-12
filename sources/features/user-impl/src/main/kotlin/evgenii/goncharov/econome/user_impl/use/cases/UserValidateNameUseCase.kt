package evgenii.goncharov.econome.user_impl.use.cases

import evgenii.goncharov.econome.user_impl.models.UserStatusModel

internal fun interface UserValidateNameUseCase {

    operator fun invoke(userName: String?) : UserStatusModel
}