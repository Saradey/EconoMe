package evgenii.goncharov.econome.product_cost_analysis_impl.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

@Composable
internal fun ListShopsScreen(
    goToAddCostGoods: () -> Unit,
    goToAddShop: () -> Unit,
    goToAnalysisGoodsCost: () -> Unit,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = "18. ListShopsFragment Список магазинов для анализа затрат",
            color = Color.White,
            fontSize = 20.sp
        )
        Button(
            onClick = goToAddCostGoods,
        ) {
            Text("Go to 19. Экран добавления стоимости товара")
        }
        Button(
            onClick = goToAddShop,
        ) {
            Text("Go to 20. Экран добавления магазина")
        }
        Button(
            onClick = goToAnalysisGoodsCost,
        ) {
            Text("Go to 23. Экран аналитики стоимости товаров")
        }
    }
}