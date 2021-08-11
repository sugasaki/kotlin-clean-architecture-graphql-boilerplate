package domain.entity.user

import domain.exceptions.EmailInvalidException
import kotlin.test.Test
import kotlin.test.assertFailsWith

class EmailTests {

    @Test
    fun `Valid`() {
        Email("steve@pekehoge.com")
    }

    @Test
    fun `Invalid Email`() {
        assertFailsWith<EmailInvalidException> {
            Email("steve")
        }
    }
}
