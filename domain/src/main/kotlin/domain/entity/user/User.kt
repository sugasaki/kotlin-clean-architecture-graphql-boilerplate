package domain.entity.user

import com.mapk.annotations.KConverter
import domain.entity.IEntity

data class User
@KConverter constructor(
    override val id: Long = -1,
    val firstName: String,
    val lastName: String,
    val email: Email
) : IEntity
