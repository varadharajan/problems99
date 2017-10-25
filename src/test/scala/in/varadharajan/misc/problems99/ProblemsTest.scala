package in.varadharajan.misc.problems99

import org.scalatest.{FlatSpec, Matchers}

import in.varadharajan.misc.problems99._


class Problem1Test extends FlatSpec with Matchers {
  "last" should "return the last element of the list" in {
    Problem1.last(List(1,2,3,4,5)) shouldBe Some(5)
  }

  "last" should "return None for empty list" in {
    Problem1.last(List()) shouldBe None
  }
}

class Problem2Test extends FlatSpec with Matchers {
  "penultimate" should "return last but one element of the list" in {
    Problem2.penultimate(List(1,2,3)) shouldBe Some(2)
  }

  "penultimate" should "return None for list with one or zero elements" in {
    Problem2.penultimate(List(1)) shouldBe None
    Problem2.penultimate(List()) shouldBe None
  }
}

class Problem3Test extends FlatSpec with Matchers {
  "nth" should "return the nth element of the list" in {
    Problem3.nth(1, List(1,2,3)) shouldBe Some(2)
  }

  "nth" should "return None for invalid index" in {
    Problem3.nth(100, List()) shouldBe None
    Problem3.nth(10, List(1)) shouldBe None
  }
}


class Problem4Test extends FlatSpec with Matchers {
  "length" should "return the number of elements in the list" in {
    Problem4.length(List(1,2,3,4)) shouldBe 4
    Problem4.length(List()) shouldBe 0
  }
}

class Problem5Test extends FlatSpec with Matchers {
  "reverse" should "reverse the list" in {
    Problem5.reverse(List(1,2,3)) shouldBe List(3,2,1)
    Problem5.reverse(List()) shouldBe List()
  }
}

class Problem6Test extends FlatSpec with Matchers {
  "palindrome" should "figure out if a list is a palindrome" in {
    Problem6.palindrome(List(1,2,3,2,1)) shouldBe true
    Problem6.palindrome(List(1,2,3,2)) shouldBe false
  }
}


class Problem7Test extends FlatSpec with Matchers {
  "flatten" should "flatten a list" in {
    Problem7.flatten(List(List(1,2,3),10, List(4))) shouldBe List(1,2,3,10,4)
  }
}

class Problem8Test extends FlatSpec with Matchers {
  "compress" should "remove consecutive duplicate elements in the list" in {
    Problem8.compress(List(1,1,2,2,3,4,3)) shouldBe List(1,2,3,4,3)
    Problem8.compress(List(1)) shouldBe List(1)
  }
}

class Problem9Test extends FlatSpec with Matchers {
  "drop" should "remove multiple of index elements" in {
    Problem9.drop(2, List(1,2,3,4,5,6,7)) shouldBe List(1,3,5,7)
  }
}

class Problem10Test extends FlatSpec with Matchers {
  "rotate" should "cycle elements in the list" in {
    Problem10.rotate(3, List('a','b','c','d','e')) shouldBe List('d', 'e', 'a', 'b', 'c')
  }
}