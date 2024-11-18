package racingcar.application

import racingcar.domain.Cars
import racingcar.domain.MoveStrategy

class RacingGame(
    command: CreateGameCommand,
) {
    private val numberOfRounds: Int = command.numberOfRounds
    private val cars: Cars = Cars(command.numberOfCars)

    fun play(moveStrategy: MoveStrategy): GameResult {
        val result: MutableList<RoundResult> = mutableListOf()
        repeat(numberOfRounds) {
            cars.move(moveStrategy)
            result.add(RoundResult(cars))
        }
        return GameResult(result)
    }
}

data class CreateGameCommand(
    val numberOfCars: Int,
    val numberOfRounds: Int,
)
