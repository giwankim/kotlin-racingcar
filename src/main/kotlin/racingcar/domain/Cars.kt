package racingcar.domain

class Cars(
    private val size: Int,
) {
    private val cars = List(size) { Car() }

    val positions: List<Int>
        get() = cars.map { it.position }

    fun move(moveStrategy: MoveStrategy) {
        cars.forEach { it.move(moveStrategy) }
    }
}
