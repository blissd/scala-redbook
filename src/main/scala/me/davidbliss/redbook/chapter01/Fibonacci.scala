package me.davidbliss.redbook.chapter01

import scala.annotation.tailrec

object Fibonacci {

  // exercise 2.1
  def fib(n: Int): Int = {
    require(n >= 0)

    @tailrec
    def loop(i: Int, a: Int, b: Int): Int = {
      if (i == n) a + b
      else loop(i + 1, b, a + b)
    }

    if (n == 0) 0
    else loop(1, 0, 1)
  }

}
