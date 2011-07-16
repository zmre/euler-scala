/* Problem 7
* http://projecteuler.net/index.php?section=problems&id=7
*
* By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13,
* we can see that the 6th prime is 13.
*
* What is the 10001st prime number?
*
*/
object Problem7 {
  import scala.collection.mutable.ListBuffer
  var cache=collection.mutable.HashMap.empty[Long,ListBuffer[Long]]

  def main(args: Array[String]) {
    test()
    println(findTheNthPrimeNumber(10001))
  }

  def test() {
    //assert(findPrimeFactors(5).max==5)
    assert(findTheNthPrimeNumber(6)==13)
  }

  def findTheNthPrimeNumber(high: Int) = {
    var numPrimes = 1
    var i = 3
    //println(2)
    while (numPrimes < high) {
      if (findPrimeFactors(i).length == 1) {
        //println(i)
        numPrimes += 1
      }
      i += 1
    }
    i - 1
  }

  /* Utility func, adapted from Problem 5 */
  /* Todo: add cache */
  def findPrimeFactors(num: Long): ListBuffer[Long] = {
    if (cache contains num)
      return cache(num)
    val answers=new ListBuffer[Long];
    (2 to scala.math.sqrt(num).toInt).foreach(divisor =>
      if (num % divisor == 0) {
        answers ++= findPrimeFactors(divisor)
        answers ++= findPrimeFactors(num / divisor)
        return answers
      }
    )
    if (answers.size == 0)
      answers += num
    cache += (num -> answers)
    answers
  }

}

// vim: set ts=4 sw=4 et:
