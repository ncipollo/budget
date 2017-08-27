package njc.budget.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import njc.budget.database.converters.Converters
import njc.budget.database.dao.LineItemDao
import njc.budget.database.entity.LineItemEntity

/**
 * Primary database for storing budget information.
 */
@Database(entities = arrayOf(LineItemEntity::class), version = 1)
@TypeConverters(Converters::class)
abstract class BudgetDatabase : RoomDatabase() {
    abstract fun lineItemDao(): LineItemDao
}