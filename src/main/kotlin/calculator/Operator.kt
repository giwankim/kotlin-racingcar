package calculator

enum class Operator(
    val symbol: String,
) {
    ADD("+") {
        override fun apply(
            x: Int,
            y: Int,
        ): Int = x + y
    },
    SUBTRACT("-") {
        override fun apply(
            x: Int,
            y: Int,
        ): Int = x - y
    },
    MULTIPLY("*") {
        override fun apply(
            x: Int,
            y: Int,
        ): Int = x * y
    },
    DIVIDE("/") {
        override fun apply(
            x: Int,
            y: Int,
        ): Int = if (y != 0) x / y else throw IllegalArgumentException("0으로 나눌 수 없습니다.")
    }, ;

    abstract fun apply(
        x: Int,
        y: Int,
    ): Int

    companion object {
        private val symbolToOperator = entries.associateBy(Operator::symbol)

        fun fromSymbol(symbol: String): Operator = symbolToOperator[symbol] ?: throw IllegalArgumentException("${symbol}은 사칙 연산 기호가 아닙니다.")
    }
}
