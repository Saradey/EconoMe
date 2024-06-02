package evgenii.goncharov.econome.common_provider.managers.impl

import android.content.Context
import android.content.Intent
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.IntentSenderRequest
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

    override fun authUser(
        resultLauncher: ActivityResultLauncher<IntentSenderRequest>,
        failureListener: () -> Unit
    ) {
        oneTapSignInClient.beginSignIn(createAuthRequest())
            .addOnSuccessListener { signInResult ->
                val sender =
                    IntentSenderRequest.Builder(signInResult.pendingIntent.intentSender).build()
                resultLauncher.launch(sender)
            }
            .addOnFailureListener { exception ->
                failureListener()
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
                    .setServerClientId(resourceManager.getString(R.string.server_client_id_debug))
                    .setFilterByAuthorizedAccounts(false)
                    .build()
            )
            .setAutoSelectEnabled(true)
            .build()
        return request
    }

    override fun getSignInCredentialFromIntent(intent: Intent): String {
        val credential = oneTapSignInClient.getSignInCredentialFromIntent(intent)
        val idToken = credential.googleIdToken
        val email = credential.id
        val displayName = credential.displayName
        return ""
    }
}