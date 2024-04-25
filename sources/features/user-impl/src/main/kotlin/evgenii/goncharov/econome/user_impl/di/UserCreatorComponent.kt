package evgenii.goncharov.econome.user_impl.di

import dagger.Component

@Component
internal interface UserCreatorComponent : UserCreatorInternal {

    @Component.Factory
    interface Factory {

        fun create(): UserCreatorComponent
    }
}