package lambda.domain.auth

trait PasswordHasher[F[_]] {

  def hash(input: String): F[HashedPassword]
  def check(input: String, hashedPassword: HashedPassword): F[Boolean]

}
