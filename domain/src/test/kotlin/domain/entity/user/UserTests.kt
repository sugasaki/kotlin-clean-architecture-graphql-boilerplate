package domain.entity.user

import domain.exceptions.EmailInvalidException
import kotlin.test.Test
import kotlin.test.assertFailsWith

class UserTests {

    @Test
    fun `Valid`() {
        User(
            id = 2,
            firstName = "steve",
            lastName = "vai",
            email = Email("steve@pekehoge.com")
        )
    }

    @Test
    fun `Invalid Email`() {
        assertFailsWith<EmailInvalidException> {
            User(
                id = 2,
                firstName = "steve",
                lastName = "vai",
                email = Email("steve")
            )
        }
    }
}
