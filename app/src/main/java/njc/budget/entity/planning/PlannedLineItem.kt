package njc.budget.entity.planning

import njc.budget.entity.LineItem
import njc.budget.entity.LineItemCategory
import njc.budget.entity.Money

/**
 * Represents a line item which is part of the planned budget. This typically represents a repeating
 * expense or income source.
 */
data class PlannedLineItem(override val name: String,
                           override val category: LineItemCategory,
                           override val amount: Money) : LineItem