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

  test("init") {
    init(List(1, 2, 3, 4, 5)) shouldBe List(1, 2, 3, 4)
  }

  test("init empty") {
    init(Nil) shouldBe Nil
  }

  test("length in foldRight") {
    List.length(List(1, 2, 3, 4, 5)) shouldBe 5
  }

  test("foldLeft") {
    foldLeft(List(1, 2, 3, 4, 5), 0)(_ + _) shouldBe 15
  }

  test("sum in foldLeft") {
    sum3(List(1, 2, 3, 4, 5)) shouldBe 15
  }

  test("product in foldLeft") {
    product3(List(1, 2, 3, 4, 5)) shouldBe 120
  }

  test("length in foldLeft") {
    List.length2(List(1, 2, 3, 4, 5)) shouldBe 5
  }

  test("foldRight example from book") {
    foldRight(List(1, 2, 3), Nil: List[Int])(Cons(_, _)) shouldBe List(1, 2, 3)
  }

  test("reverse in foldLeft") {
    reverse(List(1, 2, 3)) shouldBe List(3, 2, 1)
    reverse(Nil) shouldBe Nil
  }
}
