package evgenii.goncharov.econome.category.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class DefaultCategoryListDto(
    @SerialName("default_categories") val defaultCategories: List<DefaultCategoryDto>,
)
