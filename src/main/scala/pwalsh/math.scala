package pwalsh.math

object Math {
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

// TODO: rewrite using tail recursion so we can do very large numbers
  def findPrimeFactors(num: Long): List[Long] = {
    if ((primeCache !? CacheContains(num)).asInstanceOf[Boolean])
      return (primeCache !? CacheGet(num)).asInstanceOf[List[Long]]
    var answers = List[Long]()
    if (num != 2)
      (2 to scala.math.sqrt(num).toInt).foreach(divisor =>
        if (num % divisor == 0) {
          answers = findPrimeFactors(divisor) ++ answers
          answers = findPrimeFactors(num / divisor) ++ answers
          return answers
        }
      )
    if (answers.size == 0)
      answers = List(num) ++ answers
    primeCache ! CacheStore(num, answers)
    answers
  }

}


// vim: set ts=4 sw=4 et:
