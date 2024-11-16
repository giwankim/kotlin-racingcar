package calculator

class Calculator {
    fun calculate(input: String): Int {
        require(input.isNotBlank()) { "입력값이 빈 공백 문자입니다." }
        val expression: Expr = Parser(input).parse()
        return expression.evaluate()
    }
}
