package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {
    @Test
    fun `named arguments`() {
        val people: List<Person> =
            listOf(
                Person("박재성", 29, "제이슨"),
                Person("박재성", 29, nickname = "제이슨"),
                Person(name = "박재성", nickname = "제이슨", age = 29),
            )
        assertThat(people).allSatisfy {
            assertThat(it.name).isEqualTo("박재성")
            assertThat(it.age).isEqualTo(29)
            assertThat(it.nickname).isEqualTo("제이슨")
        }
    }

    @Test
    fun `nullable types`() {
        val person = Person("박재성", 29, null)
        assertThat(person.nickname).isNull()
    }

    @Test
    fun `default arguments`() {
        val person = Person("박재성", 29)
        assertThat(person.nickname).isEqualTo("박재성")
    }

    @Test
    fun `data classes`() {
        val person1 = Person("박재성", 29, "제이슨")
        val person2 = Person("박재성", 29, "제이슨")
        assertThat(person1).isEqualTo(person2)
    }
}
