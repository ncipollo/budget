package njc.budget.entity

interface Budget<out T : LineItem> {
    val name: String
    val lineItems: List<T>
    val totalLineItemName: String

    val total: LineItem
        get() = lineItems.map { it.amount }
                .reduce { acc, money -> acc + money }
                .let { TotalLineItem(it, totalLineItemName) }
}

private data class TotalLineItem(override val amount: Money, override val name: String) : LineItem {
    override val category: LineItemCategory = LineItemCategory.TOTAL
}