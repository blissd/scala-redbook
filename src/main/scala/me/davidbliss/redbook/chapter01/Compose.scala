package me.davidbliss.redbook.chapter01

object Compose {

  // exercise 2.5
  def compose[A,B,C](f: B => C, g: A => B): A => C = a => f(g(a))
}
