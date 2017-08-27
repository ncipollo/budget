package njc.budget.repository

import io.reactivex.Flowable
import njc.budget.domain.model.planning.PlannedBudget
import njc.budget.domain.model.planning.PlannedLineItem


class PlanedBudgetRepository {

    val budget: Flowable<PlannedBudget>
        get() = TODO("Return from dao")

    fun addLineItem(lineItem: PlannedLineItem) = Unit

    fun removeLineItems(lineItems: List<PlannedLineItem>) = Unit
}