package evgenii.goncharov.econome.product_categories_impl.di.components

import dagger.Component
import evgenii.goncharov.econome.di_core.di.scopes.FeatureScope
import evgenii.goncharov.econome.product_categories_impl.di.modules.AddSubProductBindModule

@FeatureScope
@Component(
    modules = [AddSubProductBindModule::class]
)
internal interface AddSubProductComponent {

    @Component.Factory
    interface Factory {

        fun create(): AddSubProductComponent
    }
}