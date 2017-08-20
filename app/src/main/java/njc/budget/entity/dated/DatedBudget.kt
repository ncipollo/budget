package njc.budget.entity.dated

import njc.budget.entity.Budget
import java.util.*

/**
 * A budget for a specific date range.
 */
data class DatedBudget(override val name: String,
                       override val lineItems: List<DatedLineItem>,
                       override val totalLineItemName: String,
                       val dateRange: ClosedRange<Date>) : Budget<DatedLineItem> {
}