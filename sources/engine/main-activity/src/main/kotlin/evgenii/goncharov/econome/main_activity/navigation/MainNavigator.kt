package evgenii.goncharov.econome.main_activity.navigation

import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentFactory
import androidx.fragment.app.FragmentManager
import com.github.terrakok.cicerone.Back
import com.github.terrakok.cicerone.Command
import com.github.terrakok.cicerone.Forward
import com.github.terrakok.cicerone.Replace
import com.github.terrakok.cicerone.androidx.FragmentScreen
import evgenii.goncharov.econome.navigation.base.BaseNavigator
import evgenii.goncharov.econome.main_activity.R

internal class MainNavigator(
    private val activity: FragmentActivity
) : BaseNavigator() {

    override val fm: FragmentManager = activity.supportFragmentManager
    override val ff: FragmentFactory = fm.fragmentFactory
    override val containerId: Int = R.id.container

    override fun applyCommand(command: Command) {
        when (command) {
            is Forward -> forward(command)
            is Replace -> replace(command)
            is Back -> back()
        }
    }

    private fun forward(command: Forward) {
        val fragmentScreen = command.screen as FragmentScreen
        val fragment = fragmentScreen.createFragment(ff)
        if (fragment is DialogFragment) {
            fragment.show(fm, null)
            return
        }
        commitFragmentTransaction(
            fragment = fragment,
            fragmentScreen = fragmentScreen,
            backStackName = fragmentScreen.screenKey
        )
    }

    private fun replace(command: Replace) {
        fm.popBackStack()
        val fragmentScreen = command.screen as FragmentScreen
        val fragment = fragmentScreen.createFragment(ff)
        commitFragmentTransaction(
            fragment = fragment,
            fragmentScreen = fragmentScreen,
            backStackName = fragmentScreen.screenKey
        )
    }

    private fun back() {
        if (fm.backStackEntryCount > FIRST_INDEX_FRAGMENT_TO_BACKSTACK) {
            fm.popBackStack()
        } else {
            activity.finish()
        }
    }

    private companion object {

        const val FIRST_INDEX_FRAGMENT_TO_BACKSTACK = 1
    }
}