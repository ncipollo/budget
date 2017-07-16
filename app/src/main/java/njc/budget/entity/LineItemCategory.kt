package njc.budget.entity

enum class LineItemCategory(val categoryString: String) {
    INCOME("income"),
    RENT("rent"),
    UTILITY_BILL("utility"),
    STUDENT_LOANS("loans"),
    TOTAL("total"),
    OTHER("other");

    companion object {
        private val categoryMap: Map<String, LineItemCategory>
                = LineItemCategory.values().map { it.categoryString to it }.toMap()

        fun fromString(string: String): LineItemCategory = categoryMap[string] ?: OTHER
    }


    override fun toString(): String = categoryString
}