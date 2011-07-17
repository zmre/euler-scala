package pwalsh

object pwmath {
  import scala.collection.mutable.ListBuffer
  var cache=collection.mutable.HashMap.empty[Long,ListBuffer[Long]]

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
