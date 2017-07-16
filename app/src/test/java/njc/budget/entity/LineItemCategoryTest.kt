package njc.budget.entity

import org.junit.Assert.*
import org.junit.Test

class LineItemCategoryTest {
    @Test
    fun fromString_knownCategories() {
        LineItemCategory.values().forEach {
            assertEquals(it, LineItemCategory.fromString(it.categoryString))
        }
    }

    @Test
    fun fromString_other() {
        assertEquals(LineItemCategory.OTHER, LineItemCategory.fromString("x"))
    }

    @Test
    fun toStringTest() {
        LineItemCategory.values().forEach {
            assertEquals(it.categoryString, it.toString())
        }
    }
}