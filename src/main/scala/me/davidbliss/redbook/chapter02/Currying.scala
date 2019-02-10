package me.davidbliss.redbook.chapter02

object Currying {

  // exercise 2.3
  def curry[A, B, C](f: (A, B) => C): A => B => C = a => (b: B) => f(a, b)

  // exercise 2.4
  def uncurry[A, B, C](f: A => B => C): (A, B) => C = (a, b) => f(a)(b)

}
