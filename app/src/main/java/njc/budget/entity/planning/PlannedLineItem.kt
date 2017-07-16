package njc.budget.entity.planning

import njc.budget.entity.LineItem
import njc.budget.entity.LineItemCategory
import njc.budget.entity.Money


data class PlannedLineItem(override val name: String,
                           override val category: LineItemCategory,
                           override val amount: Money) : LineItem