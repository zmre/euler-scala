package test.scala
import org.scalatest.Spec
import scala.collection.mutable.ListBuffer
import pwalsh.math._

class MathSpec extends Spec {
  describe("FindPrimeFactors") {
    it("should get the max prime factors for these") {
      expect(83) { Math.findPrimeFactors(13197).max }
      expect(6599) { Math.findPrimeFactors(13198).max }
      expect(197) { Math.findPrimeFactors(13199).max }
      expect(13) { Math.findPrimeFactors(819).max }
      expect(21317) { Math.findPrimeFactors(21317).max }
      expect(19) { Math.findPrimeFactors(21318).max }
    }
    it("should get a list of prime factors for these") {
      expect(List[Long](5,7,13,29)) { Math.findPrimeFactors(13195).sorted }
      expect(List[Long](2,2,3299)) { Math.findPrimeFactors(13196).sorted }
      expect(List[Long](5)) { Math.findPrimeFactors(5).sorted }
      expect(List[Long](2,5,5)) { Math.findPrimeFactors(50).sorted }
    }
  }
  describe("isPrime") {
    it("should correctly identify prime numbers") {
      expect(true) { Math.isPrime(7) }
      expect(true) { Math.isPrime(21317) }
      expect(true) { Math.isPrime(21319) }
      expect(true) { Math.isPrime(2) }
      expect(true) { Math.isPrime(1) }
      expect(false) { Math.isPrime(27) }
      expect(false) { Math.isPrime(21287) }
    }
  }
}


// vim: set ts=4 sw=4 et
