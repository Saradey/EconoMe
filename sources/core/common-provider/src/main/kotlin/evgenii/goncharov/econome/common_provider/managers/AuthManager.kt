package evgenii.goncharov.econome.common_provider.managers

import android.content.Intent
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.IntentSenderRequest

public interface AuthManager {

    public fun authUser(
        resultLauncher: ActivityResultLauncher<IntentSenderRequest>,
        failureListener: () -> Unit
    )

    public fun getSignInCredentialFromIntent(intent: Intent): String
}