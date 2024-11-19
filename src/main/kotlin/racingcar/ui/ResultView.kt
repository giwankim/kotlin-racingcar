package racingcar.ui

import racingcar.domain.GameResult
import racingcar.domain.RoundResult

private const val RESULTS_HEADER = "\n실행 결과"
private const val POSITION_DELIMITER = "-"
private const val WINNER_SEPARATOR = ", "

fun printResult(result: GameResult) {
    println(RESULTS_HEADER)
    printRounds(result.resultsByRound)
    printWinners(result.getWinnerNames())
}

private fun printRounds(results: List<RoundResult>) = results.forEach(::printRound)

private fun printRound(result: RoundResult) {
    val (names, positions) = result
    names.zip(positions).forEach { (name, position) ->
        printNameAndPosition(name, position)
    }
    println()
}

private fun printNameAndPosition(
    name: String,
    position: Int,
) {
    println("$name : ${POSITION_DELIMITER.repeat(position)}")
}

private fun printWinners(winners: List<String>) {
    val names = winners.joinToString(WINNER_SEPARATOR)
    println("$names 가 최종 우승했습니다.")
}
