package njc.budget.domain.model.dated

import njc.budget.domain.model.LineItem
import njc.budget.domain.model.LineItemCategory
import njc.budget.domain.model.Money
import java.util.*

/**
 * Represents a [LineItem] which was entered on a specific date.
 */
data class DatedLineItem(override val name: String,
                         override val category: LineItemCategory,
                         override val amount: Money,
                         val date: Date) : LineItem {
}