package domain.repository

import com.github.michaelbull.result.Result
import domain.DomainMessage
import domain.entity.user.User

interface IUserRepository {
    suspend fun findById(id: Long): Result<User, DomainMessage>
}
