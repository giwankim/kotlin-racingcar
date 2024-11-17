package racingcar.application

import racingcar.domain.Cars

data class GameResult(
    val resultsByRound: List<RoundResult>,
) {
    val numberOfRounds: Int = resultsByRound.size
    val numberOfCars: Int = resultsByRound.firstOrNull()?.size ?: 0
}

data class RoundResult(
    private val cars: Cars,
) {
    val positions: List<Int> = cars.positions
    val size: Int = cars.size
}
