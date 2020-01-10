package lambda.domain.code

sealed trait SourceFile {
  def fileName: Option[String]
}

object SourceFile {

  case class ClasspathResource(name: String) extends SourceFile {
    def fileName: Option[String] = name.split('/').last.trim match {
      case "" => None
      case str => Some(str)
    }
  }

  case class RawText(content: String, fileName: Option[String] = None) extends SourceFile

}