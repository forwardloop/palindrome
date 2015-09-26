import scala.annotation.tailrec

object Palindrome {

  def findLongestPalindromes(s: String, howMany: Int): List[Palindrome]  = {
    @tailrec
    def findPalindromes(s: String, len: Int, accum: List[Palindrome], cutOff: Int): List[Palindrome] =
      if (len <= 1 || accum.size == cutOff) accum
      else findPalindromes(s, len - 1, findPalindromesWithLength(s, idx=0, len, accum), cutOff)

    findPalindromes (s, s.length, Nil, howMany) sortBy (- _.len)
  }

  @tailrec
  def findPalindromesWithLength(s: String, idx: Int, len: Int, accum: List[Palindrome]): List[Palindrome] = {
    if (idx + len > s.length) accum
    else {
      val s1 = s.substring(idx, idx + len)
      val accum1 =
        if (isPalindrome(s1) && ! accum.exists(_.txt.contains(s1))) Palindrome(s1, idx, len) :: accum
        else accum

      findPalindromesWithLength(s, idx + 1, len, accum1)
    }
  }

  def isPalindrome(s: String): Boolean =
    if (s.length % 2 == 0) {  //odd length strings are not palindromes
      val half = s.length / 2
      s.take(half) == s.takeRight(half).reverse
    } else false


  def main(args: Array[String]): Unit = {
    val palins = findLongestPalindromes("sqrrqabccbatudefggfedvwhijkllkjihxymnnmzpop", 3)
    println(s"\n${palins mkString ("\n\n")}")
  }

}


case class Palindrome(txt: String, idx: Int, len: Int) {

  override def toString() = s"Text: $txt, Index: $idx, Length: $len"

}