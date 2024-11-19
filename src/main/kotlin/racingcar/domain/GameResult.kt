package racingcar.domain

data class GameResult(
    val resultsByRound: List<RoundResult>,
) {
    val numberOfRounds: Int = resultsByRound.size
    val numberOfCars: Int = resultsByRound.firstOrNull()?.numberOfCars ?: 0

    fun getWinnerNames(): List<String> = resultsByRound.last().getWinnerNames()
}

data class RoundResult(
    val names: List<String>,
    val positions: List<Int>,
) {
    val numberOfCars: Int
        get() = positions.size

    init {
        require(names.isNotEmpty()) { "자동차 이름이 없습니다." }
        require(positions.isNotEmpty()) { "자동차 위치가 없습니다." }
        require(names.size == positions.size) { "자동차 이름과 위치의 개수가 일치하지 않습니다." }
    }

    constructor(cars: Cars) : this(cars.names, cars.positions)

    fun getMaxPosition(): Int = positions.maxOrNull() ?: throw IllegalStateException("결과겂이 없습니다.")

    fun getWinnerNames(): List<String> {
        val maxPosition = getMaxPosition()
        return names
            .zip(positions)
            .filter { it.second == maxPosition }
            .map { it.first }
    }
}
