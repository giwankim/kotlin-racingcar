package calculator

class Operands(
    tokens: List<String>,
) {
    private val operands: MutableList<Int>

    init {
        require(tokens.all { it.toIntOrNull() != null }) { "피연산자가 숫자가 아닙니다." }
        operands = tokens.map { it.toInt() }.toMutableList()
    }

    fun removeFirst(): Int = operands.removeFirst()
}
