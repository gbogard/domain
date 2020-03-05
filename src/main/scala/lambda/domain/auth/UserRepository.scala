package lambda.domain.auth

import cats.data.OptionT

trait UserRepository[F[_]] {

  def persistUser(user: User, hashedPassword: String): F[User]

  def getUserByUserName(userName: String): OptionT[F, (User, String)]
}
