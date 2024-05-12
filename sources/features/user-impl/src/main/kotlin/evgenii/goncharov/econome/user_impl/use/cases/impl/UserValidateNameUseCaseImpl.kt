package evgenii.goncharov.econome.user_impl.use.cases.impl

import evgenii.goncharov.econome.user_impl.models.UserStatusModel
import evgenii.goncharov.econome.user_impl.use.cases.UserValidateNameUseCase
import javax.inject.Inject

internal class UserValidateNameUseCaseImpl @Inject constructor() : UserValidateNameUseCase {

    override fun invoke(userName: String?): UserStatusModel {
        return UserStatusModel.Success
//        return userName.isNullOrEmpty().not() &&
//                userName?.isNotBlank() == true
    }
}