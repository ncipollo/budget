package njc.budget.entity

/**
 * Represents an expense or payment in a budget.
 */
interface LineItem {
    val name: String
    val category: LineItemCategory
    val amount: Money
}