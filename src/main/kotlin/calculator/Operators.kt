package calculator

class Operators(
    tokens: List<String>,
) {
    private val operators: MutableList<Operator> = tokens.map { Operator.fromSymbol(it) }.toMutableList()

    fun removeFirst(): Operator = operators.removeFirst()

    fun isNotEmpty(): Boolean = operators.isNotEmpty()
}
