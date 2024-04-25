package evgenii.goncharov.econome.di.modules

import dagger.Binds
import dagger.Module
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
import evgenii.goncharov.econome.main_activity.di.contracts.MainActivityApi
import evgenii.goncharov.econome.main_activity.di.holder.MainActivityHolder
import evgenii.goncharov.econome.di_core.holders.FeatureHolder
import evgenii.goncharov.econome.user_api.di.UserCreatorApi
import evgenii.goncharov.econome.user_impl.di.holder.UserCreatorHolder
import javax.inject.Singleton

@Module
interface FeatureHoldersModule {

    @[Binds Singleton IntoMap ClassKey(MainActivityApi::class)]
    fun bindMainActivityHolder(mainActivityHolder: MainActivityHolder): FeatureHolder<*>

    @[Binds Singleton IntoMap ClassKey(UserCreatorApi::class)]
    fun bindUserCreatorHolder(mainActivityHolder: UserCreatorHolder): FeatureHolder<*>
}