package lambda.domain

sealed trait Media

object Media {
  case class ClasspathResource(path: String) extends Media
}