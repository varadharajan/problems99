package in.varadharajan.misc.problems99

import org.scalatest.{FlatSpec, Matchers}


class Problem1Test extends FlatSpec with Matchers {
  "last" should "return the last element of the list" in {
    Problem1.last(List(1,2,3,4,5)) shouldBe Some(5)
  }

  "last" should "return None for empty list" in {
    Problem1.last(List()) shouldBe None
  }
}
