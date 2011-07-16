/* Problem 5
* http://projecteuler.net/index.php?section=problems&id=5
*
* 2520 is the smallest number that can be divided by each of the numbers from 1 to 10
* without any remainder.
*
* What is the smallest positive number that is evenly divisible by all of the numbers
* from 1 to 20?
*
*
*/
object Problem5 {
  import scala.collection.mutable.ListBuffer

  def main(args: Array[String]) {
    test
    println(leastCommonMultipleAllNumsUpTo(20))
  }

  def test {
    assert(doItSmart(10) == 2520)
    assert(doItSmart(4) == 12)
    assert(doItSmart(5) == 60)
    assert(doItSmart(6) == 60)
  }

  def leastCommonMultipleAllNumsUpTo(high:Int) = {
    var l:List[List[Long]] = List()
    findPrimeFactors(15)
    (2 to high).foreach(a=>{
      val tmp:List[Long] = findPrimeFactors(a).toList
      l = l ++ List(tmp)
    })
    val answer = mergeAll(l)
    answer.product
  }

  def mergeFactors(a:List[Long], b:List[Long]) = a.diff(b) ++ b

  def mergeAll(l:List[List[Long]]) = {
    var a:List[Long] = List()
    l.foreach(b => a = mergeFactors(a, b))
    a
  }

  /* Initial manual effort -- used to verify result */
  def findFirstNumDivisibleBy1Through20(): Long = {
    (2520 to (2*3*4*5*6*7*8*9*10*11*12) by 20).foreach(a =>
      if (a % 19 == 0 && a % 18 == 0 && a % 17 == 0 && a % 16 == 0 && a % 14 == 0 && a % 13 == 0 && a % 11 == 0)
        return a
    )
    0
  }

  def verifyCorrect(num: Long): Boolean = {
    (2 to 20).foreach(denom =>
      if (num % denom != 0)
        return false
    )
    true
  }

  /* Utility func, adapted from Problem 3 and fixed to accurately return factors with no dupes */
  def findPrimeFactors(num: Long): ListBuffer[Long] = {
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
    answers
  }

}

// vim: set ts=4 sw=4 et:
