/* Problem 9
* http://projecteuler.net/index.php?section=problems&id=9
*
* A Pythagorean triplet is a set of three natural numbers, a  b  c, for which,
*
* a2 + b2 = c2
* For example, 32 + 42 = 9 + 16 = 25 = 52.
*
* There exists exactly one Pythagorean triplet for which a + b + c = 1000.
* Find the product abc.
*
*/
package euler
object Problem9 extends pwalsh.Euler {
  //import scala.collection.mutable.ListBuffer

  def run {
    val triplet = findPythagTripletSum(1000)
    println(triplet)
    println(triplet.product)
  }

  def getCandidateNumbers(max: Int) = (0 to max/2).toList
  def getSquaresAsPairs(candidates: List[Int]) = candidates.map(math.pow(_,2).toInt).zipWithIndex
  //def filterCandidateCombos(candidates: List[(Int,Int)], sum:Int) = {
  def findPythagTripletSum(sum: Int) = {
    val candidates = getSquaresAsPairs(getCandidateNumbers(sum))
    val solution = candidates.combinations(2).filter {
        case (List((aSquared:Int, a:Int),(bSquared:Int, b:Int))) => {
          val c = math.sqrt(aSquared+bSquared)
          a > 0 && b > 0 && c > 0 && c % 1 == 0 && a+b+c==sum
        }
        case x => false
      }.flatten.map(_._2).toList

    (sum - solution.sum) :: solution sorted
    //(solution.first._2, solution.last._2,
  }
}

// vim: set ts=4 sw=4 et:
