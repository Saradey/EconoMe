package evgenii.goncharov.econome.current_user.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import evgenii.goncharov.econome.current_user.di.api.CurrentUserApi
import evgenii.goncharov.econome.di_core.di.scopes.CoreScope

@CoreScope
@Component(
    modules = [
    ]
)
internal interface CurrentUserComponent : CurrentUserApi {

    @Component.Factory
    interface Factory {

        fun create(@BindsInstance appContext: Context): CurrentUserComponent
    }
}