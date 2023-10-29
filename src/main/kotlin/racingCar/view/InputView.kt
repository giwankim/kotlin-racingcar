package racingCar.view

import racingCar.error.ErrorMessage

object InputView {
    fun inputNumber(): Int {
        try {
            return readLine()!!.toInt()
        } catch (e: NullPointerException) {
            throw IllegalArgumentException(ErrorMessage.NULL_MESSAGE.message)
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException(ErrorMessage.INPUT_NUMBER_MESSAGE.message)
        } catch (e: Throwable) {
            throw IllegalArgumentException(ErrorMessage.INPUT_ERROR.message)
        }
    }

    fun inputCars(): String {
        val input = readLine()
        require(!input.isNullOrEmpty()) { ErrorMessage.NULL_EMPTY_MESSAGE.message }
        return input
    }
}
