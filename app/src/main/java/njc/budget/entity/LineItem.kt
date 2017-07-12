package njc.budget.entity

/**
 * Represents an expense or payment in a budget.
 */
data class LineItem(val name: String,
               val amount: Money)