package evgenii.goncharov.econome.core_database_impl.converters

import androidx.room.TypeConverter
import java.util.Date

internal class DateConverter {

    @TypeConverter
    fun fromTimestamp(value: Long): Date {
        return Date(value)
    }

    @TypeConverter
    fun dateToTimestamp(date: Date): Long {
        return date.time
    }
}