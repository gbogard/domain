package lambda.domain.auth

import java.time.LocalDateTime

case class User (
  id: User.UserId,
  userName: String,
  emailAddress: String,
  createdAt: LocalDateTime,
  lastLoggedIn: LocalDateTime
)

object User {
  case class UserId(id: String) extends AnyVal
}
