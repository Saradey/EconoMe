package evgenii.goncharov.econome.user_impl.fragments

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.fragment.app.viewModels
import evgenii.goncharov.econome.di_core.CoreFragment
import evgenii.goncharov.econome.user_api.di.UserCreatorApi
import evgenii.goncharov.econome.user_impl.di.contracts.UserCreatorInternal
import evgenii.goncharov.econome.user_impl.view.models.UserCreatorViewModel

/**
 *  0. Screen
 */
internal class UserCreatorFragment : CoreFragment() {

    private val dependency: UserCreatorInternal by lazy {
        getFeatureApi(UserCreatorApi::class.java) as UserCreatorInternal
    }
    private val viewModel: UserCreatorViewModel by viewModels {
        dependency.provideViewModelFactory()
    }

    @Composable
    override fun InitContent() {
        viewModel
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

    override fun releaseDependencies() {
        releaseFeatureApi(UserCreatorApi::class.java)
    }

    companion object {

        fun newInstance() = UserCreatorFragment()
    }
}