package evgenii.goncharov.econome.user_impl.fragments

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import evgenii.goncharov.econome.di_core.CoreFragment

/**
 *  0. Screen
 */
internal class UserCreatorFragment : CoreFragment() {

    @Composable
    override fun InitContent() {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Text(
                text = "UserCreatorFragment Создание пользователя",
                color = Color.White,
                fontSize = 20.sp
            )
        }
    }

    companion object {

        fun newInstance() = UserCreatorFragment()
    }
}