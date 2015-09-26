import scala.annotation.tailrec

object Palindrome {

  @tailrec
  def findPalinsWithLength(s: String, idx: Int, len: Int, acc: List[Palindrome]): List[Palindrome] = {
    if (idx + len > s.length) acc
    else {
      val s1 = s.substring(idx, idx + len)
      val acc1: List[Palindrome] =
        if (isPalin(s1) && isNew(s1, acc)) Palindrome(s1, idx, len) :: acc
        else acc

      findPalinsWithLength(s, idx + 1, len, acc1)
    }
  }

  @tailrec
  def findPalins(s: String, len: Int, accum: List[Palindrome], cutOff: Int): List[Palindrome] = {
    if (len <= 1 || accum.size == 3) accum
    else {
      println(s"findPalin $len acc $accum")
      findPalins(s, len - 2, findPalinsWithLength(s, 0, len, accum), cutOff)
    }
  }

  def isPalin(s: String): Boolean =
    if (s.length % 2 == 0) {  //odd length strings are not palindromes
      val half = s.length / 2
      val front = s.take(half)
      val back = s.takeRight(half)
      front == back.reverse
    } else false


  def isNew(s: String, acc: List[Palindrome]): Boolean = acc.find(_.txt.contains(s)).isEmpty

  def findLongestPalins(s: String, howMany: Int) = findPalins(s, s.length, Nil, howMany)

  def main(args: Array[String]): Unit = println( findLongestPalins("sqrrqabccbatudefggfedvwhijkllkjihxymnnmzpop", 3) )

}

case class Palindrome(txt: String, idx: Int, len: Int) {

  override def toString() = s"Text: $txt, Index: $idx, Length: $len"

}