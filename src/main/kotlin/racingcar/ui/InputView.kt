package racingcar.ui

import racingcar.application.CreateGameCommand

object InputView {
    private const val NUMBER_OF_CARS_INPUT_PROMPT = "자동차 대수는 몇 대인가요?"
    private const val NUMBER_OF_ROUNDS_INPUT_PROMPT = "시도할 회수는 몇 회인가요?"
    private const val VALIDATION_FAIL_NUM_CARS_PROMPT = "자동차 수는 1 이상의 정수여야 합니다."
    private const val VALIDATION_FAIL_NUM_ROUNDS_PROMPT = "횟수는 1 이상의 정수여야 합니다."

    fun getGameParameters(): CreateGameCommand {
        val numberOfCars = getNumberOfCars()
        val numberOfRounds = getNumberOfRounds()
        return CreateGameCommand(numberOfCars, numberOfRounds)
    }

    private fun getNumberOfCars(): Int {
        println(NUMBER_OF_CARS_INPUT_PROMPT)
        val rawInput = readln()
        if (!validate(rawInput)) {
            println(VALIDATION_FAIL_NUM_CARS_PROMPT)
            return getNumberOfCars()
        }
        return rawInput.toInt()
    }

    private fun getNumberOfRounds(): Int {
        println(NUMBER_OF_ROUNDS_INPUT_PROMPT)
        val rawInput = readln()
        if (!validate(rawInput)) {
            println(VALIDATION_FAIL_NUM_ROUNDS_PROMPT)
            return getNumberOfRounds()
        }
        return rawInput.toInt()
    }

    private fun validate(rawInput: String): Boolean {
        val result = rawInput.toIntOrNull()
        return result != null && result > 0
    }
}
