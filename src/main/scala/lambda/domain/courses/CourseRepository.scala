package lambda.domain.courses

import lambda.domain.courses.Course._

trait CourseRepository[F[_]] {

  def getCourses(): F[List[CourseManifest]]

  def getCourse(id: CourseId): F[Option[Course]]

  def getWidget(id: WidgetId): F[Option[Widget]]

  def getCourseManifest(id: CourseId): F[Option[CourseManifest]]

}
