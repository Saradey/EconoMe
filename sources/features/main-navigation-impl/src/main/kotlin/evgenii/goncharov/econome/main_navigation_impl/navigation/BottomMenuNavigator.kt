package evgenii.goncharov.econome.main_navigation_impl.navigation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import androidx.fragment.app.FragmentManager
import com.github.terrakok.cicerone.Command
import com.github.terrakok.cicerone.Forward
import com.github.terrakok.cicerone.androidx.FragmentScreen
import evgenii.goncharov.econome.main_navigation_impl.R
import evgenii.goncharov.econome.navigation.base.BaseNavigator

internal class BottomMenuNavigator(
    fragmentContainer: Fragment
) : BaseNavigator() {

    override val fm: FragmentManager = fragmentContainer.childFragmentManager
    override val ff: FragmentFactory = fragmentContainer.childFragmentManager.fragmentFactory
    override val containerId: Int = R.id.fcv_deep_stack

    override fun applyCommand(command: Command) {
        when (command) {
            is Forward -> forward(command)
        }
    }

    private fun forward(command: Forward) {
        val fragmentScreen = command.screen as FragmentScreen
        val featureContainerFragment = fragmentScreen.createFragment(ff)
        commitFragmentTransaction(
            fragment = featureContainerFragment,
            fragmentScreen = fragmentScreen,
            backStackName = fragmentScreen.screenKey
        )
    }
}