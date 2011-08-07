/* Problem 3
* http://projecteuler.net/index.php?section=problems&id=3
*
* The prime factors of 13195 are 5, 7, 13 and 29.
*
* What is the largest prime factor of the number 600851475143 ?
*           (that's 600.8 billion)
*
*/
package euler

object Problem3 extends pwalsh.Euler {
  import pwalsh.math.Math._

  def run {
    println(findPrimeFactors(600851475143l).max)
  }

}

// vim: set ts=4 sw=4 et:
