package evgenii.goncharov.econome.core_database_impl.converters

import androidx.room.TypeConverter

internal class LongsListConverter {

    @TypeConverter
    fun fromStringToListLong(list: String): List<Long> {
        return list.split(LIST_DELIMITER_SEPARATOR).map { item ->
            item.toLong()
        }
    }

    @TypeConverter
    fun listLongToString(list: List<Long>): String {
        return list.joinToString(separator = LIST_DELIMITER_SEPARATOR)
    }

    private companion object {

        const val LIST_DELIMITER_SEPARATOR = "|"
    }
}