package infrastructure.config

import domain.repository.IUserRepository
import interfaces.controller.user.UsersController
import org.koin.dsl.module
import repository.user.UserRepository
import usecase.user.FindUsers
import usecase.user.IFindUsers

val AppModule = module {
    // Controllers
    single { UsersController(get()) }

    // Services
    single<IFindUsers> { FindUsers(get()) }

    // Repositories
    single<IUserRepository> { UserRepository() }
}
