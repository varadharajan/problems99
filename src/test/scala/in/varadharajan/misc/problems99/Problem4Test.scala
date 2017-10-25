package in.varadharajan.misc.problems99

import org.scalatest.{FlatSpec, Matchers}

class Problem4Test extends FlatSpec with Matchers {
  "length" should "return the number of elements in the list" in {
    Problem4.length(List(1,2,3,4)) shouldBe 4
    Problem4.length(List()) shouldBe 0
  }
}
