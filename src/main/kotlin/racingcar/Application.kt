package racingcar

import racingcar.application.RacingGame
import racingcar.domain.RandomMoveStrategy
import racingcar.ui.InputView
import racingcar.ui.printResult

fun main() {
    val command = InputView.getGameParameters()

    val game = RacingGame(command)

    val result = game.play(RandomMoveStrategy())
    printResult(result)
}
