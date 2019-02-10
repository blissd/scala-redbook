package me.davidbliss.redbook.chapter02

import org.scalatest.{FunSuite, Matchers}

import Currying._

class CurryingTest extends FunSuite with Matchers {

  def plus(a: Int, b: Int): Int = a + b

  test("curry") {
    val plus10 = curry(plus)(10)
    plus10(5) shouldBe 15
  }

  test("uncurry") {
    val uncurriedPlus = uncurry(curry(plus))
    uncurriedPlus(6, 5) shouldBe 11
  }
}
