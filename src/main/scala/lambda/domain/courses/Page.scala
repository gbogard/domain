package lambda.domain.courses

import Page._

sealed trait Page {
  def id: PageId
  def title: String
}

object Page {

  case class PageId(underlying: String) extends AnyVal

  case class SimplePage(
    id: PageId,
    title: String,
    widgets: List[Widget]
  ) extends Page

  case class CodePage(
    id: PageId,
    title: String,
    widgets: List[Widget],
    code: InteractiveCodeWidget
  ) extends Page

  case class Manifest(title: String, excerpt: Option[String])

  object Manifest {
    def fromPage(page: Page): Manifest = {
      def excerpt(widgets: List[Widget]) = widgets.collectFirst({
        case MarkdownText(_, content) => content.take(140)
      })

      Manifest(
        page.title,
        page match {
          case p: SimplePage => excerpt(p.widgets)
          case p: CodePage => excerpt(p.widgets)
        }
      )
    }
  }
}