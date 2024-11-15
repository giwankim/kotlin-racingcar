package calculator

class Parser(
    input: String,
) {
    val tokens = input.trim().split(DELIMITER_REGEX)
    val operands: Operands
    val operators: Operators

    init {
        require(tokens.size % 2 == 1) { "연산자와 피연산자의 숫자가 맞지 않습니다." }
        val (operandTokens, operatorTokens) = tokens.withIndex().partition { it.index % 2 == 0 }
        operands = Operands(operandTokens.map { it.value })
        operators = Operators(operatorTokens.map { it.value })
    }

    fun parse(): Expr {
        var result: Expr = Literal(operands.removeFirst())
        while (operators.isNotEmpty()) {
            val operator = operators.removeFirst()
            val operand = Literal(operands.removeFirst())
            result = Binary(result, operator, operand)
        }
        return result
    }

    companion object {
        private val DELIMITER_REGEX = "\\s+".toRegex()
    }
}
