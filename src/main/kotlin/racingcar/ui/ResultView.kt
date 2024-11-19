package racingcar.ui

import racingcar.domain.GameResult
import racingcar.domain.RoundResult

private const val RESULTS_HEADER = "\n실행 결과"
private const val POSITION_DELIMITER = "-"

fun printResult(result: GameResult) {
    println(RESULTS_HEADER)
    result.resultsByRound.forEach(::printRound)
}

private fun printRound(roundResult: RoundResult) {
    roundResult.positions.forEach(::printPosition)
    println()
}

private fun printPosition(position: Int) {
    println(POSITION_DELIMITER.repeat(position))
}
