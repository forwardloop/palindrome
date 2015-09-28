import scala.annotation.tailrec

object Palindrome {

  def findLongestPalindromes(s: String, limit: Int = Int.MaxValue): List[Palindrome] = {
    @tailrec
    def findPalindromes(s: String, limit: Int, len: Int, accum: List[Palindrome]): List[Palindrome] =
      if (len <= 1 || accum.size == limit) accum
      else findPalindromes(s, limit, len - 1, findPalindromesWithLength(s, idx = 0, len, accum))

    findPalindromes (s, limit, s.length, Nil) sortBy (- _.len)
  }

  @tailrec
  def findPalindromesWithLength(s: String, idx: Int, len: Int, accum: List[Palindrome]): List[Palindrome] = {
    if (idx + len > s.length) accum
    else {
      val s1 = s.substring(idx, idx + len)
      val accum1 = if(isPalindrome(s1) && !accum.exists(_.txt.contains(s1))) Palindrome(s1, idx, len)::accum else accum
      findPalindromesWithLength(s, idx + 1, len, accum1)
    }
  }

  def isPalindrome(s: String): Boolean = {
    val s1 = s.toLowerCase filterNot (" ,!'".toSet)
    val half = s1.length / 2
    s1.take(half) == s1.takeRight(half).reverse
  }


  def main(args: Array[String]): Unit =
    if(args.length==0) println("Provide input string")
    else findLongestPalindromes(args(0), limit = 3) match {
        case Nil => println("No palindromes found")
        case pds => println(s"\n${pds mkString ("\n\n")}")
       }
}


case class Palindrome(txt: String, idx: Int, len: Int) {

  override def toString() = s"Text: $txt, Index: $idx, Length: $len"

}