package racingcar.application

import racingcar.domain.Cars
import racingcar.domain.GameResult
import racingcar.domain.MoveStrategy
import racingcar.domain.RoundResult

class RacingGame(
    private val moveStrategy: MoveStrategy,
) {
    fun play(command: PlayGameCommand): GameResult {
        val (names, numberOfRounds) = command

        val result: MutableList<RoundResult> = mutableListOf()

        val cars = Cars(names)
        repeat(numberOfRounds) {
            cars.move(moveStrategy)
            result.add(RoundResult(cars))
        }
        return GameResult(result)
    }
}

data class PlayGameCommand(
    val names: List<String>,
    val numberOfRounds: Int,
)
