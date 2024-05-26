package evgenii.goncharov.econome.common_provider.managers.impl

import android.content.Context
import evgenii.goncharov.econome.common_provider.managers.AuthManager
import javax.inject.Inject

internal class AuthManagerImpl @Inject constructor(
    private val context: Context,
) : AuthManager {

    private val oneTapSignInClient: SignInClient = Identity.getSignInClient(context)


    fun authUser() {

    }
}