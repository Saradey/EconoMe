package evgenii.goncharov.econome.category.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class DefaultCategoryDto(
    @SerialName("title_ru") val titleRu: String,
    @SerialName("title_en") val titleEn: String,
)
