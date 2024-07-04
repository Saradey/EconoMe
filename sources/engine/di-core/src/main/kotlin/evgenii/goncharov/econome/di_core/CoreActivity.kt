package evgenii.goncharov.econome.di_core

import androidx.fragment.app.FragmentActivity

public abstract class CoreActivity : FragmentActivity() {

    override fun onDestroy() {
        super.onDestroy()
        if (isFinishing) {
            releaseDependency()
        }
    }

    protected abstract fun releaseDependency()
}