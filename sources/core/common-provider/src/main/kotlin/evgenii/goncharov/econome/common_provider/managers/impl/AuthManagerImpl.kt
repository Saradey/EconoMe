package evgenii.goncharov.econome.common_provider.managers.impl

import android.content.Context
import com.google.android.gms.auth.api.identity.BeginSignInRequest
import com.google.android.gms.auth.api.identity.Identity
import com.google.android.gms.auth.api.identity.SignInClient
import evgenii.goncharov.econome.common_provider.managers.AuthManager
import javax.inject.Inject

internal class AuthManagerImpl @Inject constructor(
    context: Context,
) : AuthManager {

    private val oneTapSignInClient: SignInClient = Identity.getSignInClient(context)

    override fun authUser() {
        oneTapSignInClient.beginSignIn(createAuthRequest())
            .addOnSuccessListener { task ->

            }
            .addOnFailureListener { exception ->

            }
    }

    private fun createAuthRequest(): BeginSignInRequest {
        val request = BeginSignInRequest.builder().build()
        return request
    }
}