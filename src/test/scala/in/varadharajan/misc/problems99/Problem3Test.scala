package in.varadharajan.misc.problems99

import org.scalatest.{FlatSpec, Matchers}

class Problem3Test extends FlatSpec with Matchers {
  "nth" should "return the nth element of the list" in {
    Problem3.nth(1, List(1,2,3)) shouldBe Some(2)
  }

  "nth" should "return None for invalid index" in {
    Problem3.nth(100, List()) shouldBe None
    Problem3.nth(10, List(1)) shouldBe None
  }
}
