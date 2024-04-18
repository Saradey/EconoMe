package evgenii.goncharov.econome

import android.os.Bundle
import evgenii.goncharov.econome.di_core.CoreActivity

class MainActivity : CoreActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun releaseDependency() {
        TODO("Not yet implemented")
    }
}
