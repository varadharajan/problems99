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
  @tailrec
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

// Binary Tree problems

sealed abstract class Tree[+T] {
  def leafCount: Int
  def leafList: List[T]
}
case class Node[+T](value: T, left: Tree[T], right: Tree[T]) extends Tree[T] {
  override def toString = if(!isLeaf) s"${value}(${left.toString},${right.toString})" else s"${value}"

  override def leafCount: Int = if (isLeaf) 1 else left.leafCount + right.leafCount

  override def leafList = if (isLeaf) List(value) else left.leafList ++ right.leafList

  private def isLeaf: Boolean = left.equals(EmptyNode) && right.equals(EmptyNode)
}

case object EmptyNode extends Tree[Nothing] {
  override def toString = ""

  override def leafCount = 0

  override def leafList = List()
}

object Node {
  def apply[T](value: T): Node[T] = Node(value, EmptyNode, EmptyNode)
  def fromString(str: String): Tree[Char] = {
    def nestingLevel(chr: Char, level: Int): Int = chr match {
      case '(' => level + 1
      case ')' => level - 1
      case _ => level
    }

    def zeroLevelStringRegex(start: Int, chr: Char, level: Int = 0): Int = start match {
      case x if x < str.length && str(x).equals(chr) && level == 0 => start
      case x if x < str.length => zeroLevelStringRegex(start + 1, chr, nestingLevel(str(x), level))
      case _ => -1
    }

    def parseString() = {
      val leftTree = zeroLevelStringRegex(2, ',')
      val rightTree = zeroLevelStringRegex(leftTree, ')')
      Node(str(0), fromString(str.slice(2, leftTree)), fromString(str.slice(leftTree + 1, rightTree)))
    }

    str.length match {
      case 0 => EmptyNode
      case 1 => Node(str(0))
      case _ => parseString()
    }
  }
}

