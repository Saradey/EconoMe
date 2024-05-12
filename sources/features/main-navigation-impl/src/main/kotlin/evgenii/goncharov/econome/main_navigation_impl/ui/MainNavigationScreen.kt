package evgenii.goncharov.econome.main_navigation_impl.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import evgenii.goncharov.econome.main_navigation_impl.models.MainNavigationUiState
import evgenii.goncharov.econome.main_navigation_impl.utils.NavigationTabs
import evgenii.goncharov.econome.ui_kit.UiKitString

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun MainNavigationScreen(
    state: State<MainNavigationUiState>,
    tabBottomMenuListener: (NavigationTabs) -> Unit,
    selectedSettingsListener: () -> Unit
) {
    val uiState by state
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        TopAppBar(
            modifier = Modifier.align(Alignment.TopCenter),
            title = {},
            actions = {
                IconButton(onClick = selectedSettingsListener) {
                    Icon(
                        painter = painterResource(id = UiKitString.icon_stub),
                        contentDescription = null
                    )
                }
            }
        )

        NavigationBar(
            modifier = Modifier.align(Alignment.BottomCenter)
        ) {
            (uiState as MainNavigationUiState.Content).mainMenuItems.forEach { item ->
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
                    onClick = { tabBottomMenuListener(item.tab) },
                )
            }
        }
    }
}