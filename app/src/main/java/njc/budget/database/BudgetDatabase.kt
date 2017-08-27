package njc.budget.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import njc.budget.domain.model.Money
import njc.budget.domain.model.planning.PlannedLineItem
/**
 * Primary database for storing budget information.
 */
@Database(entities = arrayOf(Money::class, PlannedLineItem::class), version = 1)
abstract class BudgetDatabase : RoomDatabase() {
}