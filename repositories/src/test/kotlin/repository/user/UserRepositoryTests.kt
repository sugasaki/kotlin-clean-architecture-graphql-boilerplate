package repository.user

import com.github.michaelbull.result.get
import com.github.michaelbull.result.getError
import domain.UserNotFound
import kotlinx.coroutines.runBlocking
import org.assertj.core.api.Assertions.assertThat
import kotlin.test.Test

class UserRepositoryTests {

    private val repository = UserRepository()

    @Test
    fun `User tests`() {
        runBlocking {
            val id = 2L
            val actual = repository.findById(id).get()
            assertThat(actual?.id).isEqualTo(id)
        }
    }

    @Test
    fun `User inValid`() {
        runBlocking {
            val expected = UserNotFound
            val actual = repository.findById(-1).getError()
            assertThat(actual).isEqualTo(expected)
        }
    }
}
