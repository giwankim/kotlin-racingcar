package calculator

import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

@Suppress("NonAsciiCharacters")
class OperandsTest {
    @ParameterizedTest
    @MethodSource("provideTokens")
    fun `피연산자 중 숫자가 아닌 값이 있으면 예외를 던진다`(tokens: List<String>) {
        assertThatIllegalArgumentException().isThrownBy { Operands(tokens) }
    }

    companion object {
        @JvmStatic
        fun provideTokens(): List<List<String>> =
            listOf(
                listOf("*"),
                listOf("1", "/"),
                listOf("1", "-", "3"),
            )
    }
}
