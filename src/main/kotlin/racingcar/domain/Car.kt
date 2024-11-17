package racingcar.domain

class Car(
    var position: Int = 0,
) {
    init {
        require(position >= 0) { "시작점이 0 이상이어야 합니다." }
    }

    fun move(moveStrategy: MoveStrategy) {
        if (moveStrategy.canMove()) {
            position += 1
        }
    }
}
