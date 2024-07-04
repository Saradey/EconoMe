package evgenii.goncharov.econome.spending_impl.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import evgenii.goncharov.econome.spending_impl.view.models.SpendingInfoViewModel

@Composable
internal fun SpendingInfoScreen(
    viewModel: SpendingInfoViewModel
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = "5. SpendingInfoFragment Экран информации по расходу",
            color = Color.White,
            fontSize = 20.sp
        )
    }
}