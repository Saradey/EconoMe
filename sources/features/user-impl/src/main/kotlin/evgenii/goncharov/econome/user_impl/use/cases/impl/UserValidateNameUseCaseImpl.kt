package evgenii.goncharov.econome.user_impl.use.cases.impl

import evgenii.goncharov.econome.user_impl.models.UserStatusModel
import evgenii.goncharov.econome.user_impl.use.cases.UserValidateNameUseCase
import javax.inject.Inject

internal class UserValidateNameUseCaseImpl @Inject constructor() : UserValidateNameUseCase {

    override fun invoke(userName: String): UserStatusModel {
        return when {
            userName.isEmpty() || userName.isBlank() -> UserStatusModel.EmptyInput
            PATTERN_CORRECT_NAME.matches(userName) -> UserStatusModel.IncorrectInput
            else -> UserStatusModel.Success
        }
    }

    private companion object {

        val PATTERN_CORRECT_NAME = "^[a-zA-Z ]+$".toRegex()
    }
}