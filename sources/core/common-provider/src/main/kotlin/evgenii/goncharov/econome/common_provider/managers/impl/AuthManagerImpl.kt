package evgenii.goncharov.econome.common_provider.managers.impl

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import evgenii.goncharov.econome.common_provider.managers.AuthManager
import javax.inject.Inject

internal class AuthManagerImpl @Inject constructor() : AuthManager {

    private val auth : FirebaseAuth = Firebase.auth

}