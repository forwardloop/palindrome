import org.specs2._
import Palindrome._

class PalindromeSpec extends Specification { def is = s2"""

   This is the specification for the palindrome coding challenge.

   In string from assignment [$s]
      longest palindrome is 'hijkllkjih' $e4
      second longest 'defggfed'          $e5
      third longest 'abccba'             $e6

   Check if palindromes:
      'abc': no                   $e1
      'abccba': yes               $e2
      'abcccba': no               $e3

  """

  val s = "sqrrqabccbatudefggfedvwhijkllkjihxymnnmzpop"

  val (expP1, expP2, expP3) = (Palindrome("hijkllkjih", 23, 10), Palindrome("defggfed", 13, 8), Palindrome("abccba", 5, 6))

  val (s1, s2, s3) = ("abc", "abccba", "abcccba")

  def e1 = isPalindrome(s1) must beFalse

  def e2 = isPalindrome(s2) must beTrue

  def e3 = isPalindrome(s3) must beFalse

  def e4 = findLongestPalindromes(s, 3).head must beEqualTo(expP1)

  def e5 = findLongestPalindromes(s, 3).tail.head must beEqualTo(expP2)

  def e6 = findLongestPalindromes(s, 3).last must beEqualTo(expP3)

}