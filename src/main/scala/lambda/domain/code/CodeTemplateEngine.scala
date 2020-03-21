package lambda.domain.code

import java.io.File

import cats.effect.Resource

/**
 * A template engine tht can substitute user input inside source files
 */
trait CodeTemplateEngine[F[_]] {

  def render(files: List[File], userInput: Option[String]): Resource[F, List[File]]
}
