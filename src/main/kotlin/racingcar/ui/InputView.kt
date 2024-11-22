package racingcar.ui

import racingcar.application.PlayGameCommand

object InputView {
    private const val NAME_INPUT_PROMPT = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
    private const val NAME_VALIDATION_FAIL_PROMPT = "자동차 이름을 공백으로 입력했습니다."
    private const val NUMBER_OF_ROUNDS_INPUT_PROMPT = "시도할 회수는 몇 회인가요?"
    private const val NUM_ROUNDS_VALIDATION_FAIL_PROMPT = "횟수는 1 이상의 정수여야 합니다."
    private const val NAME_DELIMITER = ","

    fun getGameParameters(): PlayGameCommand {
        val names = getNames()
        val numberOfRounds = getNumberOfRounds()
        return PlayGameCommand(names, numberOfRounds)
    }

    private fun getNames(): List<String> {
        println(NAME_INPUT_PROMPT)
        val line = readln()
        if (line.isBlank()) {
            println(NAME_VALIDATION_FAIL_PROMPT)
            return getNames()
        }
        return line.trim().split(NAME_DELIMITER)
    }

    private fun getNumberOfRounds(): Int {
        println(NUMBER_OF_ROUNDS_INPUT_PROMPT)
        val rawInput = readln()
        if (!validate(rawInput)) {
            println(NUM_ROUNDS_VALIDATION_FAIL_PROMPT)
            return getNumberOfRounds()
        }
        return rawInput.toInt()
    }

    private fun validate(rawInput: String): Boolean {
        val result = rawInput.toIntOrNull()
        return result != null && result > 0
    }
}
