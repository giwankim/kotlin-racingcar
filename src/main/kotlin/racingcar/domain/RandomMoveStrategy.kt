package racingcar.domain

import kotlin.random.Random

private const val LOWER_BOUND = 0
private const val UPPER_BOUND = 10
private const val BOUNDARY_VALUE = 4

class RandomMoveStrategy : MoveStrategy {
    override fun canMove(): Boolean = Random.nextInt(LOWER_BOUND, UPPER_BOUND) >= BOUNDARY_VALUE
}
