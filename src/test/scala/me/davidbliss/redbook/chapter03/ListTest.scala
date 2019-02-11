package me.davidbliss.redbook.chapter03

import org.scalatest.{FunSuite, Matchers}

import List._

class ListTest extends FunSuite with Matchers {

  test("exercise 3.1") {
    val x = List(1, 2, 3, 4, 5) match {
      case Cons(x, Cons(2, Cons(4, _))) => x
      case Nil => 42
      case Cons(x, Cons(y, Cons(3, Cons(4, _)))) => x + y
      case Cons(h, t) => h + sum(t)
      case _ => 101
    }

    x shouldBe 3
  }

  test("tail") {
    tail(List(1, 2, 3, 4, 5)) shouldBe List(2, 3, 4, 5)
  }

  test("setHead") {
    setHead(List(1, 2, 3, 4, 5), 9) shouldBe List(9, 2, 3, 4, 5)
  }

  test("drop") {
    drop(List(1, 2, 3, 4, 5), 2) shouldBe List(3, 4, 5)
  }

  test("dropWhile") {
    dropWhile(List(1, 2, 3, 4, 5), (x: Int) => x <= 3) shouldBe List(4, 5)
  }

  test("dropWhile no matches") {
    dropWhile(List(1, 2, 3, 4, 5), (x: Int) => x == 0) shouldBe List(1, 2, 3, 4, 5)
  }

  test("dropWhile all") {
    dropWhile(List(1, 2, 3, 4, 5), (x: Int) => x < 100) shouldBe Nil
  }

}
