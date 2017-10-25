package in.varadharajan.misc.problems99

import org.scalatest.{FlatSpec, Matchers}

class Problem5Test extends FlatSpec with Matchers {
  "reverse" should "reverse the list" in {
    Problem5.reverse(List(1,2,3)) shouldBe List(3,2,1)
    Problem5.reverse(List()) shouldBe List()
  }
}
