package domain

sealed class DomainMessage

/* exposed errors */
object UserNotFound : DomainMessage()

/* internal errors */
// class DatabaseError(val reason: String?) : DomainMessage()
