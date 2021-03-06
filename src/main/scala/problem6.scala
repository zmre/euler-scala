/* Problem 6
* http://projecteuler.net/index.php?section=problems&id=6
*
* The sum of the squares of the first ten natural numbers is,
*
* 12 + 22 + ... + 102 = 385
* The square of the sum of the first ten natural numbers is,
*
* (1 + 2 + ... + 10)2 = 552 = 3025
* Hence the difference between the sum of the squares of the first ten natural
* numbers and the square of the sum is 3025  385 = 2640.
*
* Find the difference between the sum of the squares of the first one hundred
* natural numbers and the square of the sum.
*
*/
package euler
object Problem6 {
  //import scala.collection.mutable.ListBuffer

  def main(args: Array[String]) {
    //println(bruteForceFixed)
    println(differenceSumSquares(100))
  }

  def differenceSumSquares(max:Int):Int = differenceSumSquares((1 to max))
  def differenceSumSquares(min:Int, max:Int):Int = differenceSumSquares((min to max))
  def differenceSumSquares(range: Range) = {
    /* So in playing with the algebra, I discovered that the difference is the same as
    * 2*( mult-of-each-pair-of-nums )
    */
    range.toList.combinations(2).map(_.product).toList.sum*2
  }

  def bruteForceFixed = {
    val squareOfSums = math.pow((1 to 100).toList.sum.toLong,2).toLong
    val sumOfSquares = (1 to 100).toList.map(math.pow(_,2)).sum.toLong
    squareOfSums - sumOfSquares
  }


}

// vim: set ts=4 sw=4 et:
