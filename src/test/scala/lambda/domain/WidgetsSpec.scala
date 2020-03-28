package lambda.domain

import org.scalatest._
import lambda.domain.courses.InteractiveCodeWidget._
import lambda.domain.courses.{MarkdownText, MultipleChoices, WidgetId}
import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class WidgetsSpec extends AnyFunSpec with Matchers {

  describe("Widget type") {
    it("Should be 'simpleScala2' for SimpleScala2CodeWidget") {
      SimpleScala2CodeWidget(
        id = WidgetId(""),
        baseFiles = Nil,
        defaultValue = ""
      ).widgetType shouldBe "simpleScala2"
    }


    it("Should be 'tabbedScala2' for TabbedScala2CodeWidget") {
      TabbedScala2CodeWidget(
        id = WidgetId(""),
        tabs = Nil,
        baseFiles = Nil,
      ).widgetType shouldBe "tabbedScala2"
    }

    it("Should be 'markdownText' for MarkdownText") {
      MarkdownText(
        WidgetId(""),
        ""
      ).widgetType shouldBe "markdownText"
    }

    it("Should be 'multipleChoices' for MultipleChoices") {
      MultipleChoices(
        WidgetId(""),
        required = false,
        question = MultipleChoices.Question(
          "What is love ?",
          MultipleChoices.Answer(0, "Baby don't hurt me"),
          Nil
        )
      ).widgetType shouldBe "multipleChoices"
    }
  }
}
