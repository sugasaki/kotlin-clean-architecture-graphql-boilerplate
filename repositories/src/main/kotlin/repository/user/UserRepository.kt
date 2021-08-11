package repository.user

import com.github.michaelbull.result.Err
import com.github.michaelbull.result.Ok
import com.github.michaelbull.result.Result
import domain.DomainMessage
import domain.UserNotFound
import domain.entity.user.Email
import domain.entity.user.User
import domain.repository.IUserRepository

class UserRepository : IUserRepository {
    override suspend fun findById(id: Long): Result<User, DomainMessage> {
        if (id < 0) return Err(UserNotFound)

        // this mock
        val user = User(
            id = id,
            firstName = "steve",
            lastName = "vai",
            email = Email("steve@pekehoge.com")
        )
        return Ok(user)
    }
}
