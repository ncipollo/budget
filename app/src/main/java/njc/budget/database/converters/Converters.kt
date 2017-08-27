package njc.budget.database.converters

import android.arch.persistence.room.TypeConverter
import njc.budget.domain.model.LineItemCategory
import java.util.*


/**
 * Type converters for transforming types to and from primitives.
 */
class Converters {
    @TypeConverter
    fun currencyFromCode(currencyCode: String?): Currency? =
            currencyCode?.let { Currency.getInstance(currencyCode) }

    @TypeConverter
    fun currencyToCode(currency: Currency?) = currency?.currencyCode

    @TypeConverter
    fun dateFromTimestamp(timestamp: Long?) = timestamp?.let { Date(timestamp) }

    @TypeConverter
    fun dateToTimestamp(date: Date?) = date?.time

    @TypeConverter
    fun lineItemCategoryFromString(string: String?): LineItemCategory? =
            string?.let { LineItemCategory.fromString(string) }

    @TypeConverter
    fun lineItemCategoryToString(lineItemCategory: LineItemCategory?): String? =
            lineItemCategory?.categoryString
}