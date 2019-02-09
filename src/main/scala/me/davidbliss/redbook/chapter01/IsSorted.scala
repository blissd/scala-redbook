package me.davidbliss.redbook.chapter01

object IsSorted {

  // exercise 2.2
  def isSorted[A](as: Array[A], ordered: (A, A) => Boolean): Boolean = {
    def loop(i: Int): Boolean = {
      if (i == as.length) true
      else if (ordered(as(i - 1), as(i))) loop(i + 1)
      else false
    }

    if (as.length == 1) true
    else loop(1)
  }
}
