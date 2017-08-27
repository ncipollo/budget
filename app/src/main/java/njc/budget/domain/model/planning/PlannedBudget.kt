package njc.budget.domain.model.planning

import njc.budget.domain.model.Budget

/**
 * The planned budget. This will be the starting budget for each month.
 */

data class PlannedBudget(override val name: String,
                    override val lineItems: List<PlannedLineItem>) : Budget<PlannedLineItem>
