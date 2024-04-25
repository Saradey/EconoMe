package evgenii.goncharov.econome.navigation

import dagger.Component
import evgenii.goncharov.econome.di_core.di.scopes.CoreScope
import evgenii.goncharov.econome.navigation.api.CoreNavigationApi
import evgenii.goncharov.econome.navigation.modules.CoreNavigationModule

@CoreScope
@Component(modules = [CoreNavigationModule::class])
internal interface CoreNavigationComponent : CoreNavigationApi