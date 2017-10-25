package in.varadharajan.misc.problems99

import scala.annotation.tailrec

object Problem4 {
  @tailrec
  def length[A](xs: List[A], acc: Int = 0): Int = xs match {
    case Nil => acc
    case (x :: xs) => length(xs, acc + 1)
  }
}
