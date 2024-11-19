package racingcar.domain

import io.kotest.matchers.collections.containExactlyInAnyOrder
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

@Suppress("NonAsciiCharacters")
class RoundResultTest {
    @Test
    fun `이름이 없으면 예외를 던진다`() {
        assertThrows<IllegalArgumentException> { RoundResult(emptyList(), listOf(1, 2)) }
    }

    @Test
    fun `위치가 없으면 예외를 던진다`() {
        assertThrows<IllegalArgumentException> { RoundResult(listOf("a", "b"), emptyList()) }
    }

    @Test
    fun `이름과 위치의 개수가 다르면 예외를 던진다`() {
        assertThrows<IllegalArgumentException> { RoundResult(listOf("a", "b"), listOf(1, 2, 3)) }
    }

    @Test
    fun `자동차 위치의 최대값을 구한다`() {
        val result = RoundResult(listOf("a", "b", "c"), listOf(1, 2, 3))

        val maxPosition = result.getMaxPosition()

        maxPosition shouldBe 3
    }

    @Test
    fun `우승자가 한 명인 경우 한 명의 이름을 반환한다`() {
        val result = RoundResult(listOf("a", "b", "c"), listOf(1, 2, 3))

        val winners = result.getWinnerNames()

        winners shouldBe listOf("c")
    }

    @Test
    fun `다수의 우승자가 있는 경우 모든 우승자의 이름을 반환한다`() {
        val result = RoundResult(listOf("가", "a", "b", "c"), listOf(3, 1, 2, 3))

        val winners = result.getWinnerNames()

        winners should containExactlyInAnyOrder(listOf("가", "c"))
    }
}
