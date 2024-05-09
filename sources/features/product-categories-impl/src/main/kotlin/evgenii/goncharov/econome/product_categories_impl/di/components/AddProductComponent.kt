package evgenii.goncharov.econome.product_categories_impl.di.components

import dagger.Component
import evgenii.goncharov.econome.di_core.di.scopes.FeatureScope
import evgenii.goncharov.econome.product_categories_impl.di.modules.AddProductBindModule

@FeatureScope
@Component(
    modules = [AddProductBindModule::class]
)
internal interface AddProductComponent {

    @Component.Factory
    interface Factory {

        fun create(): AddProductComponent
    }
}