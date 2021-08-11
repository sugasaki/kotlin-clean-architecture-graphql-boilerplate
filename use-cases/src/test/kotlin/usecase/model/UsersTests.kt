package usecase.model

import org.assertj.core.api.Assertions
import usecase.user
import kotlin.test.Test

class UsersTests {

    @Test
    fun `toUserModel test`() {
        val expected = UserModel(id = user.id, firstName = user.firstName, lastName = user.lastName, email = user.email.value)
        val actual = user.toUserModel()
        Assertions.assertThat(actual).isEqualTo(expected)
    }
}
