/* Problem 3
* http://projecteuler.net/index.php?section=problems&id=3
*
* The prime factors of 13195 are 5, 7, 13 and 29.
*
* What is the largest prime factor of the number 600851475143 ?
*           (that's 600.8 billion)
*
*/
object Problem3 {
  import scala.collection.mutable.ListBuffer

  def main(args: Array[String]) {
    test()
    println(findPrimeFactors(600851475143l).max)
  }

  def test() {
    assert(findPrimeFactors(13195).max==29)
    assert(findPrimeFactors(13196).max==3299)
    assert(findPrimeFactors(13197).max==83)
    assert(findPrimeFactors(13198).max==6599)
    assert(findPrimeFactors(13199).max==197)
    assert(findPrimeFactors(819).max==13)
    assert(findPrimeFactors(50).max==5)
    assert(findPrimeFactors(51).max==17)
    assert(findPrimeFactors(5).max==5)
    assert(findPrimeFactors(21317).max==21317)
    assert(findPrimeFactors(21318).max==19)
  }

  def findPrimeFactors(num: Long): ListBuffer[Long] = {
    val answers=new ListBuffer[Long];
    (2 to scala.math.sqrt(num).toInt).foreach(divisor =>
      if (num % divisor == 0) {
        answers ++= findPrimeFactors(divisor)
        answers ++= findPrimeFactors(num / divisor)
      }
    )
    if (answers.size == 0)
      answers += num
    answers
  }

}

// vim: set ts=4 sw=4 et:
