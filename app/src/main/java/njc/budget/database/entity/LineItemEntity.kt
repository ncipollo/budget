package njc.budget.database.entity

import android.arch.persistence.room.Embedded
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import njc.budget.domain.model.LineItemCategory
import java.util.*

/**
 * Entity which holds line item information.
 */
@Entity(tableName = "line_item")
data class LineItemEntity(@PrimaryKey val id: Long,
                          val name: String,
                          val category: LineItemCategory,
                          @Embedded val amount: MoneyEntity,
                          val date: Date?)