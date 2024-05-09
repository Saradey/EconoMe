package evgenii.goncharov.econome.common_categories_impl.di.components

import dagger.Component
import evgenii.goncharov.econome.common_categories_impl.di.contracts.AddCategoriesInternal
import evgenii.goncharov.econome.common_categories_impl.di.modules.AddCategoriesBindModule
import evgenii.goncharov.econome.di_core.di.scopes.FeatureScope

@FeatureScope
@Component(
    modules = [
        AddCategoriesBindModule::class
    ]
)
internal interface AddCategoriesComponent : AddCategoriesInternal {

    @Component.Factory
    interface Factory {

        fun create(): AddCategoriesComponent
    }
}