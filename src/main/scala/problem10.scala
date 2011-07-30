/* Problem 10
* http://projecteuler.net/index.php?section=problems&id=10
*
* The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
*
* Find the sum of all the primes below two million.
*
*/
package euler
object Problem10 extends pwalsh.Euler {
  import pwalsh.math.Math._

  def run {
    println(sumOfPrimesBelow(2000000))
  }

  def sumOfPrimesBelow(num: Long):Long = {
    var sum:Long = 0;
    (2 to num.toInt).foreach(i =>
      if (isPrime(i))
        sum += i
    )
    sum
  }

}

// vim: set ts=4 sw=4 et:
