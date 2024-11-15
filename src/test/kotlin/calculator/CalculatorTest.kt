package calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

@Suppress("NonAsciiCharacters")
class CalculatorTest {
    private val calculator = Calculator()

    @ParameterizedTest
    @CsvSource(
        value = [
            "1 + 2 : 3",
            "2 - 1 : 1",
            "2 * 3 : 6",
            "4 / 2 : 2",
            "1 + 2 * 3 : 9",
            "2 + 3 * 4 / 2 : 10",
        ],
        delimiterString = " : ",
    )
    fun `사칙연산을 수행한다`(
        input: String,
        expected: Int,
    ) {
        val actual = calculator.calculate(input)
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `입력값이 빈 공백 문자일 경우 IllegalArgumentException 을 던진다`() {
        assertThatIllegalArgumentException().isThrownBy {
            calculator.calculate("  ")
        }
    }

    @Test
    fun `사칙연산 기호가 아닌 경우 예외를 던진다`() {
        assertThatIllegalArgumentException().isThrownBy {
            calculator.calculate("1 % 2")
        }
    }

    @Test
    fun `0으로 나누는 경우 예외를 던진다`() {
        assertThatIllegalArgumentException().isThrownBy {
            calculator.calculate("1 / 0")
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["1 +", "1 1", "1 + 2 % 3"])
    fun `잘못된 입력값인 경우 예외를 던진다`(input: String) {
        assertThatIllegalArgumentException().isThrownBy {
            calculator.calculate(input)
        }
    }
}
