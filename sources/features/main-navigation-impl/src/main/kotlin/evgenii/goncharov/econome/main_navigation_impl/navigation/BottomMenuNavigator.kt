package evgenii.goncharov.econome.main_navigation_impl.navigation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import androidx.fragment.app.FragmentManager
import com.github.terrakok.cicerone.Back
import com.github.terrakok.cicerone.Command
import com.github.terrakok.cicerone.Forward
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.FragmentScreen
import evgenii.goncharov.econome.main_navigation_impl.R
import evgenii.goncharov.econome.main_navigation_impl.models.BackStackInfo
import evgenii.goncharov.econome.navigation.base.BaseNavigator
import java.util.Stack

internal class BottomMenuNavigator(
    fragmentContainer: Fragment,
    private val globalRouter: Router
) : BaseNavigator() {

    override val fm: FragmentManager = fragmentContainer.childFragmentManager
    override val ff: FragmentFactory = fragmentContainer.childFragmentManager.fragmentFactory
    override val containerId: Int = R.id.fcv_deep_stack
    private var localBackStack: Stack<BackStackInfo> = Stack()
    private var selectedBackStack: BackStackInfo = BackStackInfo("", Stack())

    override fun applyCommand(command: Command) {
        when (command) {
            is Forward -> forward(command)
            is Back -> back()
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

    private fun back() {
        when {
            selectedBackStack.screensKey.size > FIRST_INDEX_FRAGMENT_TO_BACKSTACK -> popFragmentToCurrentBackStack()

            localBackStack.size <= FIRST_INDEX_FRAGMENT_TO_BACKSTACK -> globalRouter.exit()

            else -> popCurrentBackStack()
        }
    }

    private fun popFragmentToCurrentBackStack() {
        fm.popBackStack()
        selectedBackStack.screensKey.pop()
    }

    private fun popCurrentBackStack() {
        val popBackStack = localBackStack.pop()
        fm.popBackStack(popBackStack.backStackName, FragmentManager.POP_BACK_STACK_INCLUSIVE)
        selectedBackStack = localBackStack.peek()
        fm.restoreBackStack(selectedBackStack.backStackName)
    }

    private companion object {

        const val FIRST_INDEX_FRAGMENT_TO_BACKSTACK = 1
    }
}