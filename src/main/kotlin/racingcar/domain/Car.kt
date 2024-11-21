package racingcar.domain

class Car(
    val name: String,
    var position: Int = MIN_POSITION,
) {
    init {
        require(name.isNotBlank() && name.length <= MAX_NAME_LENGTH) { "이름은 1자 이상 5자 이하여야 합니다." }
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
        private const val MAX_NAME_LENGTH = 5
    }
}
