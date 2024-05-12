package evgenii.goncharov.econome.user_impl.models

internal sealed class UserStatusModel {

    data object Success : UserStatusModel()

    data object EmptyInput : UserStatusModel()

    data object IncorrectInput : UserStatusModel()
}