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

object Problem2 {
  @tailrec
  def penultimate[A](xs: List[A]): Option[A] = xs match {
    case _ if xs.length < 2 => None
    case (x :: _ :: Nil) => Some(x)
    case (_ :: xxs) => penultimate(xxs)
  }
}

object Problem3 {
  @tailrec
  def nth[A](n: Int, xs: List[A]): Option[A] = n match {
    case 0 if xs.nonEmpty => Some(xs.head)
    case n if n < xs.length => nth(n-1, xs.tail)
    case _ => None
  }
}


object Problem4 {
  @tailrec
  def length[A](xs: List[A], acc: Int = 0): Int = xs match {
    case Nil => acc
    case (x :: xs) => length(xs, acc + 1)
  }
}

object Problem5 {
  @tailrec
  def reverse[A](xs: List[A], acc: List[A] = List()): List[A] = xs match {
    case Nil => acc
    case x :: xs =>  reverse(xs, x :: acc)
  }
}

object Problem6 {
  def palindrome[A](xs: List[A]): Boolean = xs == Problem5.reverse(xs)
}

object Problem7 {
  def flatten(xs: List[Any]): List[Any] = xs flatMap {
    case xs: List[_] => flatten(xs)
    case x => List(x)
  }
}

object Problem8 {
  def compress[A](xs: List[A]): List[A] = {
    @tailrec
    def runner(xs: List[A], previousElement: A, acc: List[A]): List[A] = xs match {
      case Nil => acc.reverse
      case x :: xs if x.equals(previousElement) => runner(xs, x, acc)
      case x :: xs => runner(xs, x, x :: acc)
    }

    xs match {
      case Nil => List()
      case x :: xs => runner(xs, x, List(x))
    }
  }
}

object Problem9 {
  def drop[A](n: Int, xs: List[A]): List[A] = {
    xs.view.zipWithIndex.filter {
      case (elem: Int, index: Int) => (index + 1) % n != 0
    }.map(_._1).toList
  }
}

object Problem10 {
  def rotate[A](n: Int, xs: List[A]): List[A] = (xs drop n) ++ (xs take n)
}
