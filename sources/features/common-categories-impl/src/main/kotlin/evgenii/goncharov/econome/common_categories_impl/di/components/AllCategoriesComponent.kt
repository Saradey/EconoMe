package evgenii.goncharov.econome.common_categories_impl.di.components

import dagger.BindsInstance
import dagger.Component
import evgenii.goncharov.econome.common_categories_api.navigation.CommonCategoriesLauncher
import evgenii.goncharov.econome.common_categories_impl.di.contracts.AllCategoriesInternal
import evgenii.goncharov.econome.common_categories_impl.di.modules.AllCategoriesBindModule
import evgenii.goncharov.econome.di_core.di.scopes.FeatureScope

@FeatureScope
@Component(
    modules = [
        AllCategoriesBindModule::class
    ]
)
internal interface AllCategoriesComponent : AllCategoriesInternal {

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance commonCategoriesLauncher: CommonCategoriesLauncher
        ): AllCategoriesComponent
    }
}