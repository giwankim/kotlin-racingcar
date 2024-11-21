package racingcar.application

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

@Suppress("NonAsciiCharacters")
class RacingGameTest {
    private val numberOfCars = 3
    private val numberOfRounds = 5
    private val alwaysMoveForward: () -> Boolean = { true }
    private val names = listOf("pobi", "crong", "honux")
    private val command = PlayGameCommand(names, numberOfRounds)

    private lateinit var game: RacingGame

    @BeforeEach
    fun setUp() {
        game = RacingGame(alwaysMoveForward)
    }

    @Test
    fun `시도한 횟수의 결과물이 전달된다`() {
        val result = game.play(command)
        result.numberOfRounds shouldBe numberOfRounds
    }

    @Test
    fun `자동차 대수가 결과로 전달된다`() {
        val result = game.play(command)
        result.numberOfCars shouldBe numberOfCars
    }

    @Test
    fun `각 라운드별 자동차의 위치가 변경된다`() {
        val result = game.play(command)

        val expectedPositions = (1..numberOfRounds).map { round -> List(numberOfCars) { round } }
        // expectedPositions = [[1, 1, 1], [2, 2, 2], [3, 3, 3], [4, 4, 4], [5, 5, 5]]

        val actualPositions = result.resultsByRound.map { it.positions }

        actualPositions shouldBe expectedPositions
    }
}
