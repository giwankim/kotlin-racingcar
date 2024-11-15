package calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource

@Suppress("NonAsciiCharacters")
class ParserTest {
    @ParameterizedTest
    @ValueSource(strings = ["1 +", "1 + 2 *", "1 + 2 * 3 -"])
    fun `연산자와 피연산자의 숫자가 잘못됨`(input: String) {
        assertThatIllegalArgumentException().isThrownBy { Parser(input) }
    }

    @ParameterizedTest
    @MethodSource("provideInputAndExpr")
    fun `스트링을 파싱한다`(
        input: String,
        expected: Expr,
    ) {
        val actual = Parser(input).parse()
        assertThat(actual).isEqualTo(expected)
    }

    companion object {
        @JvmStatic
        fun provideInputAndExpr(): List<Arguments> =
            listOf(
                Arguments.of(
                    "1 + 2",
                    Binary(Literal(1), Operator.ADD, Literal(2)),
                ),
                Arguments.of(
                    "1 + 2 * 3",
                    Binary(
                        Binary(
                            Literal(1),
                            Operator.ADD,
                            Literal(2),
                        ),
                        Operator.MULTIPLY,
                        Literal(3),
                    ),
                ),
                Arguments.of(
                    "1 + 2 * 3 - 4",
                    Binary(
                        Binary(
                            Binary(
                                Literal(1),
                                Operator.ADD,
                                Literal(2),
                            ),
                            Operator.MULTIPLY,
                            Literal(3),
                        ),
                        Operator.SUBTRACT,
                        Literal(4),
                    ),
                ),
            )
    }
}
