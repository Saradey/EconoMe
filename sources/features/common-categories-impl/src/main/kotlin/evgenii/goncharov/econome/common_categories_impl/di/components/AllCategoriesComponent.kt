package evgenii.goncharov.econome.common_categories_impl.di.components

import dagger.Component
import evgenii.goncharov.econome.common_categories_impl.di.modules.AllCategoriesBindModule
import evgenii.goncharov.econome.di_core.di.scopes.FeatureScope

@FeatureScope
@Component(
    modules = [
        AllCategoriesBindModule::class
    ]
)
internal interface AllCategoriesComponent {

    @Component.Factory
    interface Factory {

        fun create(): AllCategoriesComponent
    }
}