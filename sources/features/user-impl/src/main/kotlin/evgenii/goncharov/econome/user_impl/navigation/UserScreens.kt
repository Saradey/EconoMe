package evgenii.goncharov.econome.user_impl.navigation

import com.github.terrakok.cicerone.androidx.FragmentScreen
import evgenii.goncharov.econome.user_impl.fragments.UserChoosingFragment
import evgenii.goncharov.econome.user_impl.fragments.UserCreatorFragment

internal object UserScreens {

    fun startUserCreator() = FragmentScreen {
        UserCreatorFragment.newInstance()
    }

    fun startUserChoosing() = FragmentScreen {
        UserChoosingFragment.newInstance()
    }
}