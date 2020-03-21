package lambda.domain

import lambda.domain.auth.User.UserId

trait IdGenerator[F[_]] {
  def randomUserId(): F[UserId]
}
