package test.scala

import org.scalatest.Spec
import euler._
class Problem6Spec extends Spec {
  describe("Problem6") {
    it("should return 2640 for diff sum squares 1 through 10") {
      expect(2640) { Problem6.differenceSumSquares(10) }
    }
    it("should return the same thing brute force vs elegant methods") {
      expect(Problem6.bruteForceFixed) { Problem6.differenceSumSquares(100) }
    }
  }
}

// vim: set ts=4 sw=4 et:
