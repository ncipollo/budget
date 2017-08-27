package njc.budget.database.dao

import android.arch.core.executor.testing.InstantTaskExecutorRule
import android.arch.persistence.room.Room
import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import njc.budget.database.BudgetDatabase
import njc.budget.database.entity.LineItemEntity
import njc.budget.database.entity.MoneyEntity
import njc.budget.domain.model.LineItemCategory
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.util.*


@RunWith(AndroidJUnit4::class)
class LineItemDaoTest {
    companion object {
        private val LINE_ITEM = LineItemEntity(1,
                "name",
                LineItemCategory.INCOME,
                MoneyEntity("1.00", Currency.getInstance("USD")),
                null)
    }

    @Rule
    @JvmField
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var database: BudgetDatabase

    @Before
    fun setUp() {
        val context = InstrumentationRegistry.getContext()
        database = Room.inMemoryDatabaseBuilder(context, BudgetDatabase::class.java)
                .allowMainThreadQueries()
                .build()

    }

    @After
    fun tearDown() {
        database.close()
    }

    @Test
    fun insert() {
        val dao = database.lineItemDao()
        dao.insertLineItems(LINE_ITEM)
        
        dao.allLineItems()
                .test()
                .assertValue(listOf(LINE_ITEM))
    }
}