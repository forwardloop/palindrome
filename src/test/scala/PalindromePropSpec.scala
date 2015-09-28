import org.scalacheck.Properties
import org.scalacheck.Prop.forAll
import Palindrome._

object PalindromePropSpec extends Properties("String") {


  property("isPalindrome") = forAll { (a: String) =>
    isPalindrome(a + (a.reverse)) == true
  }



}