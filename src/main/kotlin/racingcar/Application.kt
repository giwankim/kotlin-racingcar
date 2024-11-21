package racingcar

import racingcar.application.RacingGame
import racingcar.domain.RandomMoveStrategy
import racingcar.ui.InputView
import racingcar.ui.ResultView

fun main() {
    val command = InputView.getGameParameters()

    val game = RacingGame(command)

    val result = game.play(RandomMoveStrategy())
    ResultView.printResult(result)
}
