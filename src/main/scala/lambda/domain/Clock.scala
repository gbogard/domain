package lambda.domain

import java.time.LocalDateTime

trait Clock[F[_]] {

  def getLocalTime(): F[LocalDateTime]

}
