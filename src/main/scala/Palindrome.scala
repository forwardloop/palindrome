import scala.annotation.tailrec

object Palindrome {

  @tailrec
  def findPalinLen(s: String, idx: Int, len: Int, acc: List[Palindrome]): List[Palindrome] = {
    if (idx + len > s.length) acc
    else {
      val s1 = s.substring(idx, idx + len)
      val acc1: List[Palindrome] =
        if (isPalindrome(s1) && isNew(s1, acc)) Palindrome(s1, idx, len) :: acc
        else acc
      findPalinLen(s, idx + 1, len, acc1)
    }
  }

  @tailrec
  def findPalin(s: String, len: Int, acc: List[Palindrome]): List[Palindrome] = {
    if (len <= 1 || acc.size == 3) acc
    else {
      println(s"findPalin $len acc $acc")
      findPalin(s, len - 2, findPalinLen(s, 0, len, acc))
    }
  }

  def isPalindrome(s: String): Boolean =
    if (s.length % 2 == 0) {
      //odd length strings are not palindromes
      val half = s.length / 2
      val front = s.take(half)
      val back = s.takeRight(half)
      front == back.reverse
    } else false


  def isNew(s: String, acc: List[Palindrome]): Boolean = acc.find(_.txt.contains(s)).isEmpty



  def main(args: Array[String]): Unit = {
    println("Hello, world!")
  }

}

case class Palindrome(txt: String, idx: Int, len: Int) {

  override def toString() = s"Text: $txt, Index: $idx, Length: $len"

}