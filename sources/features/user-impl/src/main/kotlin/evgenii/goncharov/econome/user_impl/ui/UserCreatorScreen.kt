package evgenii.goncharov.econome.user_impl.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import evgenii.goncharov.econome.user_impl.models.UserCreatorUiState

@Composable
internal fun UserCreatorScreen(
    state: State<UserCreatorUiState>,
    goToWalletCreatorListener: () -> Unit,
    input: (String) -> Unit
) {
    val uiState = state.value
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = "0. UserCreatorFragment Создание пользователя",
            color = Color.White,
            fontSize = 20.sp
        )
        when (uiState) {
            is UserCreatorUiState.Content -> InputTextContent(uiState.userNameInputText, input)
            is UserCreatorUiState.ErrorInputUserName -> InputTextError(
                uiState.userNameInputText,
                uiState.errorMessage,
                input
            )
        }
        Button(
            onClick = goToWalletCreatorListener,
        ) {
            Text("Go to 4. Экран создания кошелька расходов")
        }
    }
}

@Composable
private fun InputTextContent(
    userNameInputText: String,
    inputUserNameListener: (String) -> Unit
) {
    OutlinedTextField(
        value = userNameInputText,
        onValueChange = inputUserNameListener,
        label = { Text("Введите имя пользователя") }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun InputTextError(
    userNameInputText: String,
    errorMessage: String,
    inputUserNameListener: (String) -> Unit
) {
    OutlinedTextField(
        value = userNameInputText,
        onValueChange = inputUserNameListener,
        label = { Text(errorMessage) },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Red,
            unfocusedBorderColor = Color.Red,
            errorBorderColor = Color.Red
        )
    )
}