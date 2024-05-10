package evgenii.goncharov.econome.main_activity.models

internal sealed class CheckUserModel {

    data object UserNotCreated : CheckUserModel()

    data object UserCreated : CheckUserModel()

    data object ManyUsersCreated : CheckUserModel()
}