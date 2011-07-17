/* Problem 1
* http://projecteuler.net/index.php?section=problems&id=1
* If we list all the natural numbers below 10 that are multiples of 3 or 5, we
* get 3, 5, 6 and 9. The sum of these multiples is 23.
*
* Find the sum of all the multiples of 3 or 5 below 1000.
*
*/
object Problem1 {
  def main(args: Array[String]) {
    test();
    //println(calcSumMultiplesLessThan(10, List(3,5)))
    println(calcSumMultiplesLessThan(1000, List(3,5)))
  }

  def test() {
    assert (calcSumMultiplesLessThan(10, List(3,5)) == 23)
  }

  def calcSumMultiplesLessThan(max: Int, multiples: List[Int]): Int = {
    var sum = 0;
    (1 to (max-1)).foreach(i => if (divisible(i, multiples)) sum+=i )
    sum
  }

  def divisible(numerator: Int, denominators: List[Int]): Boolean = {
    denominators.foreach(denominator => if (divisible(numerator, denominator)) return true)
    false
  }

  def divisible(numerator: Int, denominator: Int): Boolean = denominator match {
    case 0 => false
    case 1 => true
    case _ => numerator % denominator == 0
  }
}

// vim: set ts=4 sw=4 et:
