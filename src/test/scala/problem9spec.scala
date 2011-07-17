package test.scala
import org.scalatest.Spec
import euler.Problem9._
class Problem9Spec extends Spec {
  describe("Problem9") {
    it("getCandidateNumbers should return list") {
      expect(List(0,1,2,3,4,5,6)) { getCandidateNumbers(12) }
    }
    it("should return pairs of squares") {
      expect(List((0,0),(1,1),(4,2),(9,3),(16,4))) { getSquaresAsPairs(List(0,1,2,3,4)) }
    }
    it("should return the pythag triplet") {
      expect(List(3,4,5)) {
        findPythagTripletSum(12)
      }
    }
  }
}


// vim: set ts=4 sw=4 et:
