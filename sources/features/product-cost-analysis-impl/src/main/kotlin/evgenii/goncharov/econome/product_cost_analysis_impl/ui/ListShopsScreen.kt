package evgenii.goncharov.econome.product_cost_analysis_impl.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

@Composable
internal fun ListShopsScreen() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = "18. ListShopsFragment Список магазинов для анализа затрат",
            color = Color.White,
            fontSize = 20.sp
        )
    }
}