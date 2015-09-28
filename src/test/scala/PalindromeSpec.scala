import org.specs2._
import Palindrome._

class PalindromeSpec extends Specification { def is = s2"""

   This is the specification for the palindrome coding challenge.

   In string from assignment [$s]
      longest palindrome is 'hijkllkjih' $e4
      second longest 'defggfed'          $e5
      third longest 'abccba'             $e6

   Are these palindromes?
      'abc': no                             $e1
      'abccba' (even length): yes           $e2
      'abcccba' (odd length): yes           $e3
      'A man, a plan, a canal, Panama!': yes$e9
      'No 'x' in Nixon': yes                $e10
      'No 'x' in Nixoon': no                $e11

   Find longest palindromes in:
      'aBc, cbA'                            $e7
      'aA man, a plan, a canal, Panama!b'   $e8

   Find palindromes of given length
      'abccba', 4 -> 'bccb'                 $e12

  """

  val s = "sqrrqabccbatudefggfedvwhijkllkjihxymnnmzpop"

  val (expP1, expP2, expP3) = (Palindrome("hijkllkjih", 23, 10), Palindrome("defggfed", 13, 8), Palindrome("abccba", 5, 6))

  val (s1, s2, s3, s4) = ("abc", "abccba", "abcccba", "aBc, cbA")

  val (s5, s6, s7) = ("A man, a plan, a canal, Panama!", "No 'x' in Nixon", "No 'x' in Nixoon")

  def e1 = isPalindrome(s1) must beFalse

  def e2 = isPalindrome(s2) must beTrue

  def e3 = isPalindrome(s3) must beTrue

  def e9 = isPalindrome(s5) must beTrue

  def e10 = isPalindrome(s6) must beTrue

  def e11 = isPalindrome(s7) must beFalse

  def e4 = findLongestPalindromes(s, 3).head must beEqualTo(expP1)

  def e5 = findLongestPalindromes(s, 3).tail.head must beEqualTo(expP2)

  def e6 = findLongestPalindromes(s, 3).last must beEqualTo(expP3)

  def e7 = findLongestPalindromes(s4).head must beEqualTo(Palindrome(s4, 0, s4.length))

  def e8 = findLongestPalindromes("a" + s5 + "b").head must beEqualTo(Palindrome(s5, 1, s5.length))

  def e12 = {
    val pds = findPalindromesWithLength(s2, 0, 4, Nil)
    pds.size===1 and pds.head===Palindrome("bccb", 1, 4)
  }

}