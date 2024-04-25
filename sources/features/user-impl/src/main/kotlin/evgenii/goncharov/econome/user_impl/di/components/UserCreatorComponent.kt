package evgenii.goncharov.econome.user_impl.di.components

import dagger.Component
import evgenii.goncharov.econome.user_impl.di.contracts.UserCreatorInternal

@Component
internal interface UserCreatorComponent : UserCreatorInternal {

    @Component.Factory
    interface Factory {

        fun create(): UserCreatorComponent
    }
}