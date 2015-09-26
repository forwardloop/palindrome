import scala.annotation.tailrec

object Palindrome {


  val s = "sqrrqabccbatudefggfedvwhijkllkjihxymnnmzpop"

  //val s = "sqrrqabccbatu"

  val len = s.length
  val halfLen = len / 2
  val s1 = "abc"
  val s2 = s1.reverse

  @tailrec
  def findPalinLen(s: String, idx: Int, len: Int, acc: List[Palindrom]): List[Palindrom] = {
    if (idx + len > s.length) acc
    else {
      val s1 = s.substring(idx, idx + len)
      val acc1: List[Palindrom] =
        if (isPalindrome(s1) && isNew(s1, acc)) Palindrom(s1, idx, len) :: acc
        else acc
      findPalinLen(s, idx + 1, len, acc1)
    }
  }

  @tailrec
  def findPalin(s: String, len: Int, acc: List[Palindrom]): List[Palindrom] = {

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


  def isNew(s: String, acc: List[Palindrom]): Boolean = acc.find(_.txt.contains(s)).isEmpty


  //findPalin(s, Nil)
  isPalindrome("abc")
  isPalindrome("abccba")
  isPalindrome("abcccba")

  findPalinLen("aasdfsaabccbaasdfdsfdeffedddfdfd", 0, 4, Nil)

  val result: Stream[Palindrom] = findPalin(s, s.length - s.length % 2, Nil).toStream
  val r3 = result.take(3).toList
  //val result: Stream[ (String, Int, List[Palindrom]) => List[Palindrom] ] = Stream(findPalin)
  //val r3 = result map (f => f(s, s.length - s.length % 2, Nil)) take(3)
  val vv = r3.mkString("\n\n")
  println("===========")
  println(vv)

}

case class Palindrom(txt: String, idx: Int, len: Int) {

  override def toString() = s"Text: $txt, Index: $idx, Length: $len"

}