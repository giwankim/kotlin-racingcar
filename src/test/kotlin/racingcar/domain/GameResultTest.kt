package racingcar.domain

import io.kotest.matchers.collections.containExactlyInAnyOrder
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

@Suppress("NonAsciiCharacters")
class GameResultTest {
    @Test
    fun `단일 우승자 명단을 리턴한다`() {
        val result =
            GameResult(
                listOf(
                    RoundResult(listOf("a", "b", "c"), listOf(0, 0, 0)),
                    RoundResult(listOf("a", "b", "c"), listOf(1, 0, 0)),
                    RoundResult(listOf("a", "b", "c"), listOf(2, 0, 1)),
                ),
            )

        val winners = result.getWinnerNames()

        winners shouldBe listOf("a")
    }

    @Test
    fun `다수 우승자 명단을 리턴한다`() {
        val result =
            GameResult(
                listOf(
                    RoundResult(listOf("a", "b", "c"), listOf(0, 0, 0)),
                    RoundResult(listOf("a", "b", "c"), listOf(1, 0, 0)),
                    RoundResult(listOf("a", "b", "c"), listOf(1, 0, 1)),
                ),
            )

        val winners = result.getWinnerNames()

        winners should containExactlyInAnyOrder(listOf("a", "c"))
    }
}
