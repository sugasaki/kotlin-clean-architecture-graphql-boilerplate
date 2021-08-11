package domain.exceptions

open class InvalidPropertyException(message: String? = null, base: String = "Invalid property") :
    Exception(message(base, message))

class EmailInvalidException(message: String? = null, base: String = "Email invalid") :
    InvalidPropertyException(message, base)

private fun message(base: String, message: String?) = base + if (message != null) ": $message" else ""
