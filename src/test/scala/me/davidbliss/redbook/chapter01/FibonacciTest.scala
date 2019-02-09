package me.davidbliss.redbook.chapter01

import org.scalatest.{FunSuite, Matchers}

class FibonacciTest extends FunSuite with Matchers {

  test("Fib test") {
    import me.davidbliss.redbook.chapter01.Fibonacci._

    fib(0) shouldBe 0
    fib(1) shouldBe 1
    fib(2) shouldBe 2
    fib(3) shouldBe 3
    fib(4) shouldBe 5
    fib(5) shouldBe 8
    fib(6) shouldBe 13
    fib(7) shouldBe 21
    fib(8) shouldBe 34
    fib(9) shouldBe 55
    fib(10) shouldBe 89
    fib(11) shouldBe 144
  }

}
