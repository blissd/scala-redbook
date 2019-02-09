package me.davidbliss.redbook.chapter01

import me.davidbliss.redbook.chapter01.IsSorted.isSorted
import org.scalatest.{FunSuite, Matchers}

class IsSortedTest extends FunSuite with Matchers {

  def lt(a: Int, b: Int): Boolean = a < b

  def gt(a: Int, b: Int): Boolean = a > b

  test("Unsorted is not sorted") {
    val values = Array(3, 2, 1, 3, 5)
    isSorted(values, lt) shouldBe false
    isSorted(values, gt) shouldBe false
  }

  test("Sorted in ascending order") {
    val values = Array(3, 4, 5, 6, 7, 8, 9)
    isSorted(values, lt) shouldBe true
    isSorted(values, gt) shouldBe false
  }

  test("Sorted in ascending order except last") {
    val values = Array(3, 4, 5, 6, 7, 8, 9, 0)
    isSorted(values, lt) shouldBe false
    isSorted(values, gt) shouldBe false
  }

  test("Sorted in ascending order with gaps") {
    val values = Array(2, 4, 6, 8, 10)
    isSorted(values, lt) shouldBe true
    isSorted(values, gt) shouldBe false
  }

  test("Sorted in descending order") {
    val values = Array(9, 8, 7, 6, 5, 4, 3, 2, 1)
    isSorted(values, lt) shouldBe false
    isSorted(values, gt) shouldBe true
  }

  test("Sorted in descending order except last") {
    val values = Array(9, 8, 7, 6, 5, 4, 3, 2, 1, 10)
    isSorted(values, lt) shouldBe false
    isSorted(values, gt) shouldBe false
  }

  test("Sorted in descending order with gaps") {
    val values = Array(10, 8, 6, 4, 2)
    isSorted(values, lt) shouldBe false
    isSorted(values, gt) shouldBe true
  }
}
