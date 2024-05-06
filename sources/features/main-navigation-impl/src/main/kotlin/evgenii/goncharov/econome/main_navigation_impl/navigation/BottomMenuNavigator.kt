package evgenii.goncharov.econome.main_navigation_impl.navigation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit
import com.github.terrakok.cicerone.Back
import com.github.terrakok.cicerone.Command
import com.github.terrakok.cicerone.Forward
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.FragmentScreen
import evgenii.goncharov.econome.main_navigation_impl.R
import evgenii.goncharov.econome.main_navigation_impl.models.BackStackInfo
import evgenii.goncharov.econome.navigation.base.BaseNavigator
import evgenii.goncharov.econome.navigation.navigation.BACKSTACK_NAME_EVERYWHERE
import java.util.Stack

internal class BottomMenuNavigator(
    fragmentContainer: Fragment,
    private val globalRouter: Router,
    private val selectedTabListener: SelectedTabListener
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
        val name = fragmentScreen.screenKey
        val fragment = fragmentScreen.createFragment(ff)
        when {
            checkEverywhere(name) -> commitFragmentToCurrentStack(fragment, name)
            checkLocalBackStack(name) -> restoreBackStack(name)
            checkIsNewBackStack(name) -> addedNewBackStack(fragmentScreen, name)
        }
    }

    private fun checkEverywhere(backStackName: String): Boolean {
        return backStackName == BACKSTACK_NAME_EVERYWHERE
    }

    private fun checkLocalBackStack(backStackName: String): Boolean {
        return localBackStack.any { info -> info.backStackName == backStackName } &&
                selectedBackStack.backStackName != backStackName
    }

    private fun checkIsNewBackStack(backStackName: String): Boolean {
        return selectedBackStack.backStackName != backStackName &&
                backStackName != BACKSTACK_NAME_EVERYWHERE
    }

    private fun commitFragmentToCurrentStack(
        fragment: Fragment,
        screenKey: String
    ) {
        fm.commit {
            setReorderingAllowed(true)
            replace(containerId, fragment, screenKey)
            addToBackStack(selectedBackStack.backStackName)
        }
        selectedBackStack.screensKey.push(screenKey)
    }

    private fun restoreBackStack(backStackName: String) {
        fm.saveBackStack(selectedBackStack.backStackName)
        val info = localBackStack.find { info -> info.backStackName == backStackName }
        info?.let { _info -> selectedBackStack = _info }
        fm.restoreBackStack(info?.backStackName ?: throw IllegalArgumentException())
        localBackStack.remove(info)
        localBackStack.push(info)
    }

    private fun addedNewBackStack(fragmentScreen: FragmentScreen, backStackName: String) {
        if (selectedBackStack.backStackName.isNotEmpty()) {
            fm.saveBackStack(selectedBackStack.backStackName)
        }
        val fragment = fragmentScreen.createFragment(ff)
        fm.commit {
            setReorderingAllowed(true)
            replace(containerId, fragment, fragmentScreen.screenKey)
            addToBackStack(backStackName)
        }
        val backStackScreens = Stack<String>()
        backStackScreens.add(fragmentScreen.screenKey)
        selectedBackStack = BackStackInfo(backStackName, backStackScreens)
        localBackStack.push(selectedBackStack)
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
        selectedTabListener.selectTab(selectedBackStack.backStackName)
        fm.restoreBackStack(selectedBackStack.backStackName)
    }

    private companion object {

        const val FIRST_INDEX_FRAGMENT_TO_BACKSTACK = 1
    }
}