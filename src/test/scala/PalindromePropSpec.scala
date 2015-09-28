import org.scalacheck.Properties
import org.scalacheck.Prop.forAll
import Palindrome._

object PalindromePropSpec extends Properties("String") {

  property("isPalindrome") = forAll { (a: String) =>
    isPalindrome(a + (a.reverse)) == true
  }

  property("findLongestPalindromes") = forAll { (a: String, b: String, c: String) =>
    b.isEmpty || findLongestPalindromes(a + b + b.reverse + c).size > 0
  }

}