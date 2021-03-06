package me.davidbliss.redbook.chapter03

import scala.annotation.tailrec

sealed trait List[+A]

case object Nil extends List[Nothing]

case class Cons[+A](head: A, tail: List[A]) extends List[A]

object List {
  def sum(ints: List[Int]): Int = ints match {
    case Nil => 0
    case Cons(x, xs) => x + sum(xs)
  }

  def product(ds: List[Double]): Double = ds match {
    case Nil => 1.0
    case Cons(0.0, _) => 0.0
    case Cons(x, xs) => x * product(xs)
  }

  def apply[A](as: A*): List[A] =
    if (as.isEmpty) Nil
    else Cons(as.head, apply(as.tail: _*))

  def foldRight[A, B](as: List[A], z: B)(f: (A, B) => B): B = as match {
    case Nil => z
    case Cons(x, xs) => f(x, foldRight(xs, z)(f))
  }

  def sum2(ns: List[Int]) = foldRight(ns, 0)((x, y) => x + y)

  def product2(ns: List[Double]) = foldRight(ns, 1.0)(_ * _)


  // exercise 3.2
  def tail[A](as: List[A]): List[A] = drop(as, 1)

  // exercise 3.3
  def setHead[A](as: List[A], a: A): List[A] = Cons(a, tail(as))

  // exercise 3.4
  def drop[A](l: List[A], n: Int): List[A] = if (n == 0) l
  else l match {
    case Nil => Nil
    case Cons(_, t) => drop(t, n - 1)
  }

  // exercise 3.5
  def dropWhile[A](l: List[A], f: A => Boolean): List[A] = l match {
    case Cons(h, t) if f(h) => dropWhile(t, f)
    case _ => l
  }

  // exercise 3.6
  def init[A](l: List[A]): List[A] = l match {
    case Cons(a, Cons(b, Nil)) => List(a)
    case Cons(a, t) => Cons(a, init(t))
    case Nil => Nil
  }

  // exercise 3.9
  def length[A](as: List[A]): Int = foldRight(as, 0)((_, b) => b + 1)

  // exercise 3.10
  @tailrec
  def foldLeft[A, B](as: List[A], z: B)(f: (B, A) => B): B = as match {
    case Nil => z
    case Cons(h, t) => foldLeft(t, f(z, h))(f)
  }

  // exercise 3.11
  def sum3(ns: List[Int]) = foldLeft(ns, 0)((x, y) => x + y)

  def product3(ns: List[Double]) = foldLeft(ns, 1.0)(_ * _)

  def length2[A](as: List[A]): Int = foldLeft(as, 0)((b, _) => b + 1)

  // exercise 3.12
  def reverse[A](as: List[A]): List[A] = foldLeft(as, Nil: List[A])((b, a) => Cons(a, b))

  // exercise 3.13 - probably a better way to do this...
  def foldRightViaFoldLeft[A, B](as: List[A], z: B)(f: (A, B) => B): B =
    foldLeft(reverse(as), z)((b, a) => f(a, b))

  // exercise 3.14
  def append[A](as: List[A], a: A): List[A] = foldRight(as, Cons(a, Nil))((a, b) => Cons(a, b))

  // exercise 3.15
  def concat[A](l: List[List[A]]): List[A] = {

    @tailrec
    def prepend(a: List[A], b: List[A]): List[A] = a match {
      case Cons(h, t) => prepend(t, Cons(h, b))
      case Nil => b
    }

    foldLeft(l, Nil: List[A])((a,b) => prepend(reverse(a), b))
  }
}