/* Problem 4
* http://projecteuler.net/index.php?section=problems&id=4
*
* A palindromic number reads the same both ways. The largest palindrome made
* from the product of two 2-digit numbers is 9009 = 91  99.
*
* Find the largest palindrome made from the product of two 3-digit numbers.
*
*/
object Problem4 {
  import scala.collection.mutable.ListBuffer

  def main(args: Array[String]) {
    test()
    generateListOfPossiblePalindromes.reverse.foreach(palindrome =>
      if (isProductOfTwo3DigitNums(palindrome))
        return println(palindrome)
    )
  }

  def test() {
    //assert(findPrimeFactors(5).max==5)
    assert(isPalindrome(1001))
    assert(isPalindrome(10101))
    assert(isPalindrome(12101)==false)
    assert(isPalindrome(123)==false)
    assert(isPalindrome(11))
    assert(isPalindrome(1))
    assert(isProductOfTwo3DigitNums(23868))
    assert(isProductOfTwo3DigitNums(301365))
    assert(isProductOfTwo3DigitNums(9702)==false)
    assert(isProductOfTwo3DigitNums(5)==false)
    assert(isProductOfTwo3DigitNums(999999)==false)
  }

  def generateListOfPossiblePalindromes: ListBuffer[Int] = {
    val palindromes = new ListBuffer[Int]
    (100*100 to 999*999).foreach(num =>
      if (isPalindrome(num))
        palindromes += num
    )
    palindromes
  }

  def isPalindrome(num: Int): Boolean = {
    val str = num.toString
    str.startsWith(str.substring(str.length/2).reverse)
  }

  def isProductOfTwo3DigitNums(numerator: Int): Boolean = {
    (100 to 999).foreach(denominator =>
      if (numerator % denominator == 0 && (numerator / denominator).toString.length == 3)
        return true
    )
    false
  }

}

// vim: set ts=4 sw=4 et:
