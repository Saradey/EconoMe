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
    createAccountWithGoogleListener: () -> Unit,
    createAccountWithUuid: () -> Unit,
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
        InputText(
            userNameInputText = uiState.userNameInputText,
            errorMessage = uiState.errorInputMessage,
            inputUserNameListener = input
        )
        Button(
            onClick = createAccountWithUuid,
        ) {
            Text("Создать аккаунт")
        }
        Button(
            onClick = createAccountWithGoogleListener,
        ) {
            Text("Создать аккаунт с google")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun InputText(
    userNameInputText: String,
    errorMessage: String?,
    inputUserNameListener: (String) -> Unit
) {
    OutlinedTextField(
        value = userNameInputText,
        onValueChange = inputUserNameListener,
        label = { Text(errorMessage ?: "Введите имя пользователя") },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = if (errorMessage != null) Color.Red else Color.White,
            unfocusedBorderColor = if (errorMessage != null) Color.Red else Color.White,
            focusedTextColor = Color.White,
            unfocusedTextColor = Color.White,
            focusedLabelColor = if (errorMessage != null) Color.Red else Color.White,
            unfocusedLabelColor = if (errorMessage != null) Color.Red else Color.White,
            errorBorderColor = if (errorMessage != null) Color.Red else Color.White,
        )
    )
}