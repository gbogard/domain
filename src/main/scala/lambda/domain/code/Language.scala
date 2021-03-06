package lambda.domain.code

sealed trait Language {
  def id: String
}

object Language {

  case object Scala2 extends Language {
    val id = "scala2"
  }
  case object ReasonML extends Language {
    val id = "reason"
  }

}