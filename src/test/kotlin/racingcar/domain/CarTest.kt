package racingcar.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

@Suppress("NonAsciiCharacters")
class CarTest {
    @Test
    fun `시작점이 음수이면 예외를 던진다`() {
        shouldThrow<IllegalArgumentException> { Car(-1) }
    }

    @Test
    fun `이동할 경우 위치가 +1 된다`() {
        val car = Car()
        car.move { true }
        car.position shouldBe 1
    }

    @Test
    fun `이동 못하는 경우 위치가 변경되지 않는다`() {
        val car = Car()
        car.move { false }
        car.position shouldBe 0
    }
}
