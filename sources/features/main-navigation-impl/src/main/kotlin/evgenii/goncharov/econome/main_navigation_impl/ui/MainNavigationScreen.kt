package evgenii.goncharov.econome.main_navigation_impl.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import evgenii.goncharov.econome.main_navigation_impl.models.MainNavigationState
import evgenii.goncharov.econome.main_navigation_impl.utils.NavigationTabs

@Composable
internal fun MainNavigationScreen(
    state: State<MainNavigationState>,
    tabClickListener: (NavigationTabs) -> Unit
) {
    val uiState by state
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        NavigationBar(
            modifier = Modifier.align(Alignment.BottomCenter)
        ) {
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
                    onClick = { tabClickListener(item.tab) },
                )
            }
        }
    }
}