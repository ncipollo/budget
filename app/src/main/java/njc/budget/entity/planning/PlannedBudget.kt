package njc.budget.entity.planning

import njc.budget.entity.Budget

/**
 * The planned budget. This will be the starting budget for each month.
 */
class PlannedBudget(override val name: String,
                    override val lineItems: List<PlannedLineItem>,
                    override val totalLineItemName: String) :Budget<PlannedLineItem>