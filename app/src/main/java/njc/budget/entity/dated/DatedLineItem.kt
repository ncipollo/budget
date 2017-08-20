package njc.budget.entity.dated

import njc.budget.entity.LineItem
import njc.budget.entity.LineItemCategory
import njc.budget.entity.Money
import java.util.*

/**
 * Represents a [LineItem] which was entered on a specific date.
 */
data class DatedLineItem(override val name: String,
                         override val category: LineItemCategory,
                         override val amount: Money,
                         val date: Date) : LineItem {
}