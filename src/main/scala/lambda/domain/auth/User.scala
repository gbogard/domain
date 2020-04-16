package lambda.domain.auth

case class User (
  id: User.UserId,
  userName: String,
  emailAddress: String,
)

object User {
  case class UserId(id: String) extends AnyVal
}
