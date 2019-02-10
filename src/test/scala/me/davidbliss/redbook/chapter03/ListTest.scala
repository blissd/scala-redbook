package me.davidbliss.redbook.chapter03

import org.scalatest.{FunSuite, Matchers}

import List._

class ListTest extends FunSuite with Matchers {

  test("exercise 3.1") {
    val x = List(1,2,3,4,5) match {
      case Cons(x, Cons(2, Cons(4, _))) => x
      case Nil => 42
      case Cons(x, Cons(y, Cons(3, Cons(4, _)))) => x + y
      case Cons(h, t) => h + sum(t)
      case _ => 101
    }

    x shouldBe 3
  }

}