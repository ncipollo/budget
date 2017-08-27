package njc.budget.domain.model

/**
 * Represents an expense or payment in a budget.
 */
interface LineItem {
    val name: String
    val category: LineItemCategory
    val amount: Money
}