package lambda.domain.courses

import lambda.domain.code.ScalaCodeRunner.ScalaDependency
import lambda.domain.code.SourceFile
import lambda.domain.code.Language.Scala2
import lambda.domain.code.Language

case class MarkdownText(
    id: WidgetId,
    content: String
) extends StaticWidget {
  val widgetType: String = "markdownText"
}

case class MultipleChoices(
    id: WidgetId,
    required: Boolean,
    question: MultipleChoices.Question
) extends InteractiveWidget {
  val widgetType: String = "multipleChoices"
}

object MultipleChoices {

  case class Answer(id: Int, value: String)
  case class Question(
      value: String,
      rightAnswer: Answer,
      otherPropositions: List[Answer]
  )
}

sealed trait InteractiveCodeWidget extends InteractiveWidget {
  def language: Language
}

object InteractiveCodeWidget {

  case class SimpleScala2CodeWidget(
    id: WidgetId,
    baseFiles: List[SourceFile],
    defaultValue: String,
    dependencies: List[ScalaDependency] = Nil,
    required: Boolean = false
  ) extends InteractiveCodeWidget {
    val language = Scala2
    val widgetType: String = "simpleScala2"
  }

  case class TabbedScala2CodeWidget(
    id: WidgetId,
    tabs: List[SourceFile],
    baseFiles: List[SourceFile],
    dependencies: List[ScalaDependency] = Nil,
    required: Boolean = false
  ) extends InteractiveCodeWidget {
    val language = Scala2
    val widgetType: String = "tabbedScala2"
  }
}

case class WidgetId(underlying: String) extends AnyVal

sealed trait Widget {
  val widgetType: String
  def id: WidgetId
}

sealed trait StaticWidget extends Widget

sealed trait InteractiveWidget extends Widget {
  def required: Boolean
}
