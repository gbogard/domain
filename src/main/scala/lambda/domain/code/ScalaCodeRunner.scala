package lambda.domain.code

import java.io.File
import ScalaCodeRunner._

import scala.language.postfixOps
import scala.concurrent.duration._

trait ScalaCodeRunner[F[_]] {
  def runFiles(
      files: List[File],
      dependencies: List[ScalaDependency] = Nil,
      timeout: FiniteDuration = 30 seconds
  ): ProcessResult[F]

  def runCode(
    code: String,
    mainClass: String,
    dependencies: List[ScalaDependency] = Nil,
    timeout: FiniteDuration = 30 seconds
  ): ProcessResult[F]
}

object ScalaCodeRunner {
  case class ScalaDependency(
      org: String,
      name: String,
      version: String,
      scalaVersion: String = "2.12"
  )
}