package lambda.domain.code

import java.io.File
import ScalaCodeRunner._

trait ScalaCodeRunner[F[_]] {
  def runFiles(
      files: List[File],
      dependencies: List[ScalaDependency] = Nil,
  ): ProcessResult[F]

  def runCodeString(
    code: String,
    wrapInMain: Boolean = true,
    baseFiles: List[File] = Nil,
    dependencies: List[ScalaDependency] = Nil,
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