package usecase.user

import com.github.michaelbull.result.Err
import com.github.michaelbull.result.Ok
import com.github.michaelbull.result.get
import com.github.michaelbull.result.getError
import domain.UserNotFound
import domain.repository.IUserRepository
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.runBlocking
import org.assertj.core.api.Assertions
import usecase.id
import usecase.user
import usecase.userModel
import kotlin.test.Test

class FindUsersTests {

    private val repository = mockk<IUserRepository>()
    private val usecase = FindUsers(repository)

    @Test
    fun success() {
        runBlocking {
            every { runBlocking { repository.findById(id) } } returns Ok(user)
            val actual = usecase.execute(id).get()
            Assertions.assertThat(actual).isEqualTo(userModel)
        }
        verify(exactly = 1) { runBlocking { repository.findById(any()) } }
    }

    @Test
    fun `No user`() {
        runBlocking {
            val expected = UserNotFound
            every { runBlocking { repository.findById(any()) } } returns Err(UserNotFound)
            val actual = usecase.execute(-1).getError()
            Assertions.assertThat(actual).isEqualTo(expected)
        }
    }
}
