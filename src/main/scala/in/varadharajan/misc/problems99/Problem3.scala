package in.varadharajan.misc.problems99

import scala.annotation.tailrec

object Problem3 {
  @tailrec
  def nth[A](n: Int, xs: List[A]): Option[A] = n match {
    case 0 if xs.nonEmpty => Some(xs.head)
    case n if n < xs.length => nth(n-1, xs.tail)
    case _ => None
  }
}
