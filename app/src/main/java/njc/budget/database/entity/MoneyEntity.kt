package njc.budget.database.entity

import java.util.*

/**
 * Represents a set of columns which hold money information.
 */
data class MoneyEntity(val amount: String, val currency: Currency)