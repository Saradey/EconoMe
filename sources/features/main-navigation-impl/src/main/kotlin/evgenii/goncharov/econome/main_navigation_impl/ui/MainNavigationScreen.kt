package evgenii.goncharov.econome.main_navigation_impl.ui

import android.view.ViewGroup
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.viewinterop.AndroidView
import androidx.fragment.app.FragmentContainerView
import evgenii.goncharov.econome.main_navigation_impl.models.MainBottomNavItem
import evgenii.goncharov.econome.main_navigation_impl.models.MainNavigationUiState
import evgenii.goncharov.econome.main_navigation_impl.utils.NavigationTabs
import evgenii.goncharov.econome.ui_kit.UiKitDrawable

@Composable
internal fun MainNavigationScreen(
    state: State<MainNavigationUiState>,
    tabBottomMenuListener: (NavigationTabs) -> Unit,
    selectedSettingsListener: () -> Unit,
    layoutId: Int
) {
    val uiState by state
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Toolbar(
            selectedSettingsListener = selectedSettingsListener
        )
        FragmentContainer(layoutId = layoutId)
        MainNavigationBar(
            mainMenuItems = uiState.mainMenuItems,
            tabBottomMenuListener = tabBottomMenuListener
        )
    }
}

@Composable
private fun MainNavigationBar(
    modifier: Modifier = Modifier,
    mainMenuItems: List<MainBottomNavItem>,
    tabBottomMenuListener: (NavigationTabs) -> Unit
) {
    NavigationBar(
        modifier = modifier.fillMaxWidth()
    ) {
        mainMenuItems.forEach { item ->
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

@Composable
private fun FragmentContainer(
    modifier: Modifier = Modifier,
    layoutId: Int
) {
    AndroidView(
        modifier = modifier,
        factory = { context ->
            FragmentContainerView(context).apply {
                layoutParams = ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
                )
                id = layoutId
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun Toolbar(
    selectedSettingsListener: () -> Unit
) {
    TopAppBar(
        title = {},
        actions = {
            IconButton(onClick = selectedSettingsListener) {
                Icon(
                    painter = painterResource(id = UiKitDrawable.icon_stub),
                    contentDescription = null
                )
            }
        }
    )
}