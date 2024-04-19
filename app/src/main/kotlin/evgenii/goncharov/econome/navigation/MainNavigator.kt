package evgenii.goncharov.econome.navigation

import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentFactory
import androidx.fragment.app.FragmentManager
import com.github.terrakok.cicerone.Command
import evgenii.goncharov.econome.navigation.base.BaseNavigator
import evgenii.goncharov.econome.R

class MainNavigator(
    activity: FragmentActivity
) : BaseNavigator() {

    override val fm: FragmentManager = activity.supportFragmentManager
    override val ff: FragmentFactory = fm.fragmentFactory
    override val containerId: Int = R.id.container

    override fun applyCommand(command: Command) {

    }
}