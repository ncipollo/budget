package njc.budget.entity

import java.math.BigDecimal
import java.math.RoundingMode
import java.util.*

/**
 * Represents some amount of money.
 */
data class Money(val amount: BigDecimal, val currency: Currency) {

    companion object {
        /**
         * Creates a money object from the provided string. The default currency is USD.
         */
        fun fromString(moneyString: String,
                       currency: Currency = Currency.getInstance("USD")): Money {
            val amount = BigDecimal(moneyString)
                    .setScale(currency.defaultFractionDigits, RoundingMode.HALF_UP)
            return Money(amount, currency)
        }
    }

    operator fun plus(other: Money): Money = Money(this.amount + other.amount, this.currency)

    operator fun plus(number: Int): Money = Money(this.amount + BigDecimal(number), this.currency)

    operator fun minus(other: Money): Money = Money(this.amount - other.amount, this.currency)

    operator fun minus(number: Int): Money = Money(this.amount - BigDecimal(number), this.currency)
}