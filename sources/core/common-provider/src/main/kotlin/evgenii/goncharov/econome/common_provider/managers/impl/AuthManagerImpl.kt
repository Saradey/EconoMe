package evgenii.goncharov.econome.common_provider.managers.impl

import android.content.Context
import com.google.android.gms.auth.api.identity.BeginSignInRequest
import com.google.android.gms.auth.api.identity.Identity
import com.google.android.gms.auth.api.identity.SignInClient
import evgenii.goncharov.econome.common_provider.R
import evgenii.goncharov.econome.common_provider.managers.AuthManager
import evgenii.goncharov.econome.common_provider.managers.ResourceManager
import javax.inject.Inject

internal class AuthManagerImpl @Inject constructor(
    context: Context,
    private val resourceManager: ResourceManager
) : AuthManager {

    private val oneTapSignInClient: SignInClient = Identity.getSignInClient(context)

    override fun authUser() {
        oneTapSignInClient.beginSignIn(createAuthRequest())
            .addOnSuccessListener { task ->
                println(task)
            }
            .addOnFailureListener { exception ->
                println(exception)
            }
    }

    private fun createAuthRequest(): BeginSignInRequest {
        val request = BeginSignInRequest.builder()
            .setPasswordRequestOptions(
                BeginSignInRequest.PasswordRequestOptions.builder()
                    .setSupported(true)
                    .build()
            )
            .setGoogleIdTokenRequestOptions(
                BeginSignInRequest.GoogleIdTokenRequestOptions.builder()
                    .setSupported(true)
                    .setServerClientId(resourceManager.getString(R.string.server_client_id))
                    .setFilterByAuthorizedAccounts(false)
                    .build()
            )
            .setAutoSelectEnabled(true)
            .build()
        return request
    }
}