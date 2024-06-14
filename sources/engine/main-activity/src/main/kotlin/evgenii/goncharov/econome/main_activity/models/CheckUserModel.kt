package evgenii.goncharov.econome.main_activity.models

internal sealed class CheckUserModel {

    data object OpenUserCreator : CheckUserModel()

    data object OpenWalletCreator : CheckUserModel()

    data object OpenMainMenu : CheckUserModel()

    data object OpenUserChoose : CheckUserModel()
}