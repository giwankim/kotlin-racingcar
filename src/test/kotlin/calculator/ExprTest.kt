package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

@Suppress("NonAsciiCharacters")
class ExprTest {
    @Test
    fun add() {
        val expr = Binary(Literal(1), Operator.ADD, Literal(2))
        val result = expr.evaluate()
        assertThat(result).isEqualTo(3)
    }

    @Test
    fun subtract() {
        val expr = Binary(Literal(3), Operator.SUBTRACT, Literal(1))
        val result = expr.evaluate()
        assertThat(result).isEqualTo(2)
    }

    @Test
    fun multiply() {
        val expr = Binary(Literal(4), Operator.MULTIPLY, Literal(2))
        val result = expr.evaluate()
        assertThat(result).isEqualTo(8)
    }

    @Test
    fun divide() {
        val expr = Binary(Literal(10), Operator.DIVIDE, Literal(2))
        val result = expr.evaluate()
        assertThat(result).isEqualTo(5)
    }

    @Test
    fun `복잡한 Expr를 evaluate`() {
        val expr =
            Binary(
                Binary(
                    Binary(Literal(2), Operator.ADD, Literal(3)),
                    Operator.MULTIPLY,
                    Literal(4),
                ),
                Operator.DIVIDE,
                Literal(2),
            )
        // 2 + 3 * 4 / 2"
        assertThat(expr.evaluate()).isEqualTo(10)
    }
}
