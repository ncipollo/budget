package njc.budget.domain.model.planning

import njc.budget.domain.model.LineItem
import njc.budget.domain.model.LineItemCategory
import njc.budget.domain.model.Money

/**
 * Represents a line item which is part of the planned budget. This typically represents a repeating
 * expense or income source.
 */
data class PlannedLineItem(override val name: String,
                           override val category: LineItemCategory,
                           override val amount: Money) : LineItem