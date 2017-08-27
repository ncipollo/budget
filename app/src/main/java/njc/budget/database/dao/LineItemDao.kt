package njc.budget.database.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import io.reactivex.Single
import njc.budget.database.entity.LineItemEntity

@Dao
interface LineItemDao {
    @Insert
    fun insertLineItems(vararg lineItems:LineItemEntity)

    @Query("SELECT * FROM line_item")
    fun allLineItems() : Single<List<LineItemEntity>>
}