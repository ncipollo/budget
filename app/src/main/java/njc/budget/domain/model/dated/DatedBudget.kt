package njc.budget.domain.model.dated

import njc.budget.domain.model.Budget
import java.util.*

/**
 * A budget for a specific date range.
 */
data class DatedBudget(override val name: String,
                       override val lineItems: List<DatedLineItem>,
                       val dateRange: ClosedRange<Date>) : Budget<DatedLineItem>