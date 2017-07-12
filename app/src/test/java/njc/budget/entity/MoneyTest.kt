package njc.budget.entity

import org.junit.Test

import org.junit.Assert.*
import java.math.BigDecimal
import java.util.*

class MoneyTest {
    @Test
    fun equals_same() {
        val money1 = Money.fromString("1.00")
        val money2 = Money.fromString("1.00")

        assertEquals(money1, money2)
    }

    @Test
    fun equals_differentAmount() {
        val money1 = Money.fromString("1.00")
        val money2 = Money.fromString("2.00")

        assertNotEquals(money1, money2)
    }

    @Test
    fun equals_differentCurrency() {
        val money1 = Money(BigDecimal("1.00"), Currency.getInstance("USD"))
        val money2 = Money(BigDecimal("1.00"), Currency.getInstance("EUR"))

        assertNotEquals(money1, money2)
    }

    @Test
    fun fromString_defaultCurrency() {
        val money = Money.fromString("1.00")

        assertEquals(money.currency, Currency.getInstance("USD"))
    }

    @Test
    fun fromString_roundedAmount_roundDown() {
        val money = Money.fromString("1.004")

        assertEquals(BigDecimal("1.00"), money.amount)
    }

    @Test
    fun fromString_roundedAmount_roundUp() {
        val money = Money.fromString("1.005")

        assertEquals(BigDecimal("1.01"), money.amount)
    }

    @Test
    fun fromString_specifiedCurrency() {
        val money = Money.fromString("1.00", Currency.getInstance("EUR"))

        assertEquals(money.currency, Currency.getInstance("EUR"))
    }

    @Test
    fun plus_money() {
        var money = Money.fromString("1.00")
        money += Money.fromString("2.00")

        assertEquals(BigDecimal("3.00"), money.amount)
    }

    @Test
    fun plus_int() {
        var money = Money.fromString("1.00")
        money += 2

        assertEquals(BigDecimal("3.00"), money.amount)
    }

    @Test
    fun minus_money() {
        var money = Money.fromString("1.00")
        money -= Money.fromString("1.00")

        assertEquals(BigDecimal("0.00"), money.amount)
    }

    @Test
    fun minus_int() {
        var money = Money.fromString("1.00")
        money -= 1

        assertEquals(BigDecimal("0.00"), money.amount)
    }
}