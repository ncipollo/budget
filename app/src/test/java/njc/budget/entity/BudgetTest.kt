package njc.budget.entity

import org.junit.Assert
import org.junit.Test

private const val TOTAL = "total"

class BudgetTest {
    @Test
    fun total() {
        val total = SimpleBudget().total

        Assert.assertEquals(TOTAL, total.name)
        Assert.assertEquals(LineItemCategory.TOTAL, total.category)
        Assert.assertEquals(Money.fromString("2.00"), total.amount)
    }
}

private class SimpleLineItem(override val amount: Money) : LineItem {
    override val name: String = "lineItem"
    override val category: LineItemCategory = LineItemCategory.OTHER
}

private class SimpleBudget : Budget<SimpleLineItem> {
    override val name: String = "budget"
    override val lineItems: List<SimpleLineItem> = arrayListOf("1.00", "2.00", "-1.00")
            .map { SimpleLineItem(Money.fromString(it)) }

    override val totalLineItemName: String = TOTAL
}