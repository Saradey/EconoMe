package evgenii.goncharov.econome.main_activity.navigation

import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentFactory
import androidx.fragment.app.FragmentManager
import com.github.terrakok.cicerone.Command
import com.github.terrakok.cicerone.Forward
import com.github.terrakok.cicerone.Replace
import com.github.terrakok.cicerone.androidx.FragmentScreen
import evgenii.goncharov.econome.navigation.base.BaseNavigator
import evgenii.goncharov.econome.main_activity.R

internal class MainNavigator(
    activity: FragmentActivity
) : BaseNavigator() {

    override val fm: FragmentManager = activity.supportFragmentManager
    override val ff: FragmentFactory = fm.fragmentFactory
    override val containerId: Int = R.id.container

    override fun applyCommand(command: Command) {
        when (command) {
            is Forward -> forward(command)
            is Replace -> replace(command)
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

    private fun replace(command: Replace) {
        fm.popBackStack()
        val fragmentScreen = command.screen as FragmentScreen
        val featureContainerFragment = fragmentScreen.createFragment(ff)
        commitFragmentTransaction(
            fragment = featureContainerFragment,
            fragmentScreen = fragmentScreen,
            backStackName = fragmentScreen.screenKey
        )
    }
}