package njc.budget.entity

interface Budget<out T : LineItem> {
    val name: String
    val lineItems: List<T>

    val total: LineItem
        get() = lineItems.map { it.amount }
                .reduce { acc, money -> acc + money }
                .let { TotalLineItem(it) }
}

private data class TotalLineItem(override val amount: Money) : LineItem {
    override val name: String = "total"
    override val category: LineItemCategory = LineItemCategory.TOTAL
}