package evgenii.goncharov.econome.user_impl.fragments

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import evgenii.goncharov.econome.di_core.CoreFragment

/**
 *  0. Screen
 */
internal class UserCreatorFragment : CoreFragment() {

    @Composable
    override fun InitContent() {
        Text(text = "UserCreatorFragment Создание пользователя")
    }


    companion object {

        fun newInstance() = UserCreatorFragment()
    }
}