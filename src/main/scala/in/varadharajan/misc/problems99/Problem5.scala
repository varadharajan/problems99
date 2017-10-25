package in.varadharajan.misc.problems99

import scala.annotation.tailrec

object Problem5 {
  @tailrec
  def reverse[A](xs: List[A], acc: List[A] = List()): List[A] = xs match {
    case Nil => acc
    case x :: xs =>  reverse(xs, x :: acc)
  }
}
