package racingcar.domain

import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

@Suppress("NonAsciiCharacters")
class CarsTest {
    @Test
    fun `이동할 경우 위치가 변경된다`() {
        val cars = Cars(3)
        cars.move { true }
        cars.positions.forAll { it shouldBe 1 }
    }
}
