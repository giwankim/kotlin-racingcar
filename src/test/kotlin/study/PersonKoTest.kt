package study

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.nulls.shouldBeNull
import io.kotest.matchers.shouldBe

class PersonKoTest :
    StringSpec({
        "named arguments" {
            val actual = Person("홍길동", 20, "길동")
            actual.name shouldBe "홍길동"
            actual.age shouldBe 20
            actual.nickname shouldBe "길동"
        }

        "nullable types" {
            val actual = Person("홍길동", 20, null)
            actual.nickname.shouldBeNull()
        }

        "default values" {
            val actual = Person("홍길동", 20)
            actual.nickname shouldBe "홍길동"
        }

        "data classes" {
            val person1 = Person("홍길동", 20, "길동")
            val person2 = Person("홍길동", 20, "길동")
            person1 shouldBe person2
        }
    })
