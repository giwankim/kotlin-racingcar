package racingcar.domain

class Cars(
    names: List<String>,
) {
    private val cars = names.map { Car(it) }

    val positions: List<Int>
        get() = cars.map { it.position }

    val names: List<String>
        get() = cars.map { it.name }

    fun move(moveStrategy: MoveStrategy) {
        cars.forEach { it.move(moveStrategy) }
    }
}
