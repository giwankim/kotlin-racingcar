package racingcar.ui

import racingcar.application.RacingGame

class RacingGameController(
    private val game: RacingGame,
) {
    fun play() {
        val command = InputView.getGameParameters()
        val result = game.play(command)
        ResultView.printResult(result)
    }
}
