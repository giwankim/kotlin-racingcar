package calculator

enum class Operator(
    val symbol: String,
    val operation: (Int, Int) -> Int,
) {
    ADD("+", { x, y -> x + y }),
    SUBTRACT("-", { x, y -> x - y }),
    MULTIPLY("*", { x, y -> x * y }),
    DIVIDE("/", { x, y -> if (y != 0) x / y else throw IllegalArgumentException("0으로 나눌 수 없습니다.") }), ;

    fun apply(
        x: Int,
        y: Int,
    ): Int = operation(x, y)

    companion object {
        fun fromSymbol(symbol: String): Operator =
            entries.find { it.symbol == symbol } ?: throw IllegalArgumentException("${symbol}은 사칙 연산 기호가 아닙니다.")
    }
}
