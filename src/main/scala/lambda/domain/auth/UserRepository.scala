package lambda.domain.auth

import cats.data.OptionT

trait UserRepository[F[_]] {

  def persistUser(user: User, hashedPassword: HashedPassword): F[User]

  def getUserByUserName(userName: String): OptionT[F, (User, HashedPassword)]
}
