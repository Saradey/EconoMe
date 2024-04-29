package evgenii.goncharov.econome.main_navigation_impl.ui

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import evgenii.goncharov.econome.main_navigation_impl.models.MainNavigationState

@Composable
internal fun MainNavigationScreen(
    state: State<MainNavigationState>
) {
    val uiState by state
    NavigationBar {
        (uiState as MainNavigationState.Content).mainMenuItems.forEach { item ->
            NavigationBarItem(
                label = {
                    Text(text = stringResource(item.title))
                },
                icon = {
                    Icon(
                        painterResource(id = item.icon),
                        contentDescription = null
                    )
                },
                selected = item.isSelected,
                alwaysShowLabel = true,
                onClick = { },
            )
        }
    }
}