package pwalsh.math

object Math {
  import scala.collection.mutable.ListBuffer
  import pwalsh.cache._

  var primeCache = new Cacher
  primeCache.start

  def isPrime(num: Long): Boolean = {
    (2 to scala.math.sqrt(num).toInt).foreach(divisor =>
      if (num % divisor == 0) {
        return false
      }
    )
    true
  }

  def findPrimeFactors(num: Long): ListBuffer[Long] = {
    if ((primeCache !? CacheContains(num)).asInstanceOf[Boolean])
      return (primeCache !? CacheGet(num)).asInstanceOf[ListBuffer[Long]]
    val answers = new ListBuffer[Long];
    if (num != 2)
      (2 to scala.math.sqrt(num).toInt).foreach(divisor =>
        if (num % divisor == 0) {
          answers ++= findPrimeFactors(divisor)
          answers ++= findPrimeFactors(num / divisor)
          return answers
        }
      )
    if (answers.size == 0)
      answers += num
    primeCache ! CacheStore(num, answers)
    answers
  }

}


// vim: set ts=4 sw=4 et:
