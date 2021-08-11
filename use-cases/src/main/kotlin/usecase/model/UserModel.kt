package usecase.model

import com.mapk.annotations.KConverter
import com.mapk.kmapper.KMapper
import domain.entity.user.User

data class UserModel
@KConverter constructor(
    val id: Long,
    val firstName: String,
    val lastName: String,
    @ValueStringClassConverter() // Value Class -> String
    val email: String
)

fun User.toUserModel(): UserModel = KMapper(::UserModel).map(this)
