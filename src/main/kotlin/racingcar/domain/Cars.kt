package racingcar.domain

class Cars(
    numberOfCars: Int,
) {
    private val cars = List(numberOfCars) { Car() }

    val positions: List<Int>
        get() = cars.map { it.position }

    fun move(moveStrategy: MoveStrategy) {
        cars.forEach { it.move(moveStrategy) }
    }
}
