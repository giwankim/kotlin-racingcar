package racingcar.domain

class GameResult(
    val resultsByRound: List<RoundResult>,
) {
    val numberOfRounds: Int = resultsByRound.size
    val numberOfCars: Int = resultsByRound.firstOrNull()?.numberOfCars ?: 0
}

class RoundResult(
    val positions: List<Int>,
) {
    val numberOfCars: Int
        get() = positions.size

    constructor(cars: Cars) : this(cars.positions)
}
