package calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test

@Suppress("NonAsciiCharacters")
class OperatorTest {
    @Test
    fun `사칙연산이 적용된다`() {
        assertThat(Operator.ADD.apply(1, 2)).isEqualTo(3)
        assertThat(Operator.SUBTRACT.apply(3, 1)).isEqualTo(2)
        assertThat(Operator.MULTIPLY.apply(2, 4)).isEqualTo(8)
        assertThat(Operator.DIVIDE.apply(10, 2)).isEqualTo(5)
    }

    @Test
    fun `사칙연산 기호가 아닌 경우 IllegalArgumentException 을 던진다`() {
        assertThatIllegalArgumentException().isThrownBy { Operator.fromSymbol("%") }
    }

    @Test
    fun `0 으로 나누면 IllegalArgumentException 을 던진다`() {
        assertThatIllegalArgumentException().isThrownBy { Operator.DIVIDE.apply(1, 0) }
    }
}
