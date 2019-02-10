package me.davidbliss.redbook.chapter02

import org.scalatest.{FunSuite, Matchers}
import Compose._

class ComposeTest extends FunSuite with Matchers {

  test("Compose") {
    def g(a: Int): String = a.toString
    def f(a: String): List[Int] = List(a.toInt)

    val gf = compose(f, g)

    gf(7) shouldBe List(7)
  }

}
