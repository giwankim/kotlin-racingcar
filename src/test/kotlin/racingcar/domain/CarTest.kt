package racingcar.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

@Suppress("NonAsciiCharacters")
class CarTest {
    @ParameterizedTest
    @ValueSource(strings = ["", "abcdef", "가나다라마바"])
    fun `자동차의 이름이 비어 있거나 5자를 초과하면 예외를 던진다`(name: String) {
        shouldThrow<IllegalArgumentException> { Car(name) }
    }

    @Test
    fun `시작점이 음수이면 예외를 던진다`() {
        shouldThrow<IllegalArgumentException> { Car("abc", -1) }
    }

    @Test
    fun `이동할 경우 위치가 +1 된다`() {
        val car = Car("abc")
        car.move { true }
        car.position shouldBe 1
    }

    @Test
    fun `이동 못하는 경우 위치가 변경되지 않는다`() {
        val car = Car("abc")
        car.move { false }
        car.position shouldBe 0
    }
}
