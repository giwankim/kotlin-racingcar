package racingcar.domain

class Car(
    var position: Int = MIN_POSITION,
) {
    init {
        require(position >= MIN_POSITION) { "시작점이 $MIN_POSITION 이상이어야 합니다." }
    }

    fun move(moveStrategy: MoveStrategy) {
        if (moveStrategy.canMove()) {
            position += MOVE_INCREMENT
        }
    }

    companion object {
        private const val MIN_POSITION = 0
        private const val MOVE_INCREMENT = 1
    }
}
