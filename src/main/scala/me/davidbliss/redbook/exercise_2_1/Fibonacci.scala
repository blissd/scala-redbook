package me.davidbliss.redbook.exercise_2_1

import scala.annotation.tailrec

object Fibonacci {

  // exercise 2.1
  def fib(n: Int): Int = {
    require(n >= 0)

    @tailrec
    def loop(i: Int, a: Int, b: Int): Int = {
      if (i == n) a + b
      else if (i == 0) loop(1, 0, 1)
      else loop(i + 1, b, a + b)
    }

    loop(0, 0, 0)
  }

}
