package evgenii.goncharov.econome.common_categories_impl.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

@Composable
internal fun AllCategoriesScreen(
    goToAddCategories: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = "11. AllCategoriesFragment Экран всех категорий",
            color = Color.White,
            fontSize = 20.sp
        )
        Button(
            onClick = goToAddCategories,
        ) {
            Text("Go to 12. Диалоговок окно по добавлению категории")
        }
    }
}