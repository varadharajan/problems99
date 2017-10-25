package in.varadharajan.misc.problems99

import scala.annotation.tailrec

object Problem1 {
  @tailrec
  def last[A](xs: List[A]): Option[A] = xs match {
    case Nil => None
    case (x :: Nil) => Some(x)
    case (x :: xxs) => last(xxs)
  }
}
