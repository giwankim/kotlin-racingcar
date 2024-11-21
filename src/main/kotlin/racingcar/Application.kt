package racingcar

import racingcar.application.RacingGame
import racingcar.domain.MoveStrategy
import racingcar.domain.RandomMoveStrategy
import racingcar.ui.RacingGameController

object Context {
    private fun moveStrategy(): MoveStrategy = RandomMoveStrategy()

    private fun racingGame() = RacingGame(moveStrategy())

    fun racingGameController() = RacingGameController(racingGame())
}

fun main() {
    val gameController = Context.racingGameController()
    gameController.play()
}
