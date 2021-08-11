package interfaces.controller.user

import com.github.michaelbull.result.Ok
import interfaces.controller.Response
import usecase.model.UserModel
import usecase.user.IFindUsers

class UsersController(
    private val findUsersUseCase: IFindUsers,
) {
    suspend fun findById(id: Long): Response<UserModel> {
        return when (val result = findUsersUseCase.execute(id)) {
            is Ok -> Response(200, result.value)
            else -> Response(400, errorMessage = "user not found")
        }
    }
}
