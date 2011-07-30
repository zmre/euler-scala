package test.scala
import org.scalatest.Spec
import euler.Problem10._
class Problem10Spec extends Spec {
  describe("Problem10") {
    it("sum of the primes below x") {
      expect(17) { sumOfPrimesBelow(10) }
    }
  }
}


// vim: set ts=4 sw=4 et:
