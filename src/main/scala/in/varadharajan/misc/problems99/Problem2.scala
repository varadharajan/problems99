package in.varadharajan.misc.problems99

import scala.annotation.tailrec

object Problem2 {
  @tailrec
  def penultimate[A](xs: List[A]): Option[A] = xs match {
    case Nil => None
    case (_ :: Nil) => None
    case (x :: _ :: Nil) => Some(x)
    case (_ :: xxs) => penultimate(xxs)
  }
}
