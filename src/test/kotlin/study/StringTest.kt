package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.MethodSource

@Suppress("NonAsciiCharacters")
class StringTest {
    @Test
    fun `문자열의 앞뒤 공백을 제거한다`() {
        assertThat("".trim()).isEmpty()
        assertThat("     ".trim()).isEmpty()
        assertThat("  a  ".trim()).isEqualTo("a")
        assertThat("    this is a sentence.  \t\n\n".trim()).isEqualTo("this is a sentence.")
    }

    @ParameterizedTest
    @MethodSource("split")
    fun `문자열을 빈 공백 문자로 분리한다`(
        s: String,
        expected: List<String>,
    ) {
        val tokens = s.split("\\s+".toRegex())
        assertThat(tokens).isEqualTo(expected)
    }

    companion object {
        @JvmStatic
        fun split() =
            listOf(
                Arguments.of("1  +    2", listOf("1", "+", "2")),
                Arguments.of("1\n2", listOf("1", "2")),
                Arguments.of("  1 + 2   ", listOf("", "1", "+", "2", "")),
                Arguments.of(
                    "This is   a\tstring\nwith various whitespace.",
                    listOf("This", "is", "a", "string", "with", "various", "whitespace."),
                ),
            )
    }

    @ParameterizedTest
    @CsvSource("1, 1", "10, 10", "-1, -1", "a, null", "'',null", nullValues = arrayOf("null"))
    fun `코틀린의 toIntOrNull() 기능을 테스트한다`(
        s: String,
        expected: Int?,
    ) {
        assertThat(s.toIntOrNull()).isEqualTo(expected)
    }
}
