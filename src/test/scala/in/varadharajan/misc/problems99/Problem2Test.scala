package in.varadharajan.misc.problems99

import org.scalatest.{FlatSpec, Matchers}

class Problem2Test extends FlatSpec with Matchers {
  "penultimate" should "return last but one element of the list" in {
    Problem2.penultimate(List(1,2,3)) shouldBe Some(2)
  }

  "penultimate" should "return None for list with one or zero elements" in {
    Problem2.penultimate(List(1)) shouldBe None
    Problem2.penultimate(List()) shouldBe None
  }
}
