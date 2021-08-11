package domain.entity.user

import domain.entity.ValueStringClass
import domain.exceptions.EmailInvalidException

data class Email(override val value: String) : ValueStringClass {
    init {
        if (!value.contains('@')) throw EmailInvalidException()
    }
}
