package test.scala
import org.scalatest.Spec
import euler.Problem11._
import euler.Grid

class Problem11Spec extends Spec {
  describe("Problem11") {
    it("should find the greatest adjacent product in each direction length 2") {
      expect(72) {
        new Grid("""1 2 3
                    4 5 6
                    7 8 9""").findGreatestAdjacentProduct(2)
      }
      expect(72) {
        new Grid("""1 2 3
                    4 8 6
                    7 5 9""").findGreatestAdjacentProduct(2)
      }
      expect(72) {
        new Grid("""9 2 3
                    4 8 6
                    7 5 1""").findGreatestAdjacentProduct(2)
      }
      expect(72) {
        new Grid("""1 2 3
                    4 6 8
                    7 5 9""").findGreatestAdjacentProduct(2)
      }
      expect(72) {
        new Grid("""1 2 3
                    4 6 8
                    7 9 5""").findGreatestAdjacentProduct(2)
      }
      expect(72) {
        new Grid("""1 8 3
                    9 6 4
                    7 2 5""").findGreatestAdjacentProduct(2)
      }
      expect(72) {
        new Grid("""1 3 8
                    6 9 4
                    7 2 5""").findGreatestAdjacentProduct(2)
      }
    }
    it("should find the greatest adjacent product in each direction length 3") {
      expect(336) {
        println("***********************")
        new Grid("""1 2 3 4
                    5 6 7 8
                    7 6 5 4
                    3 2 1 0""").findGreatestAdjacentProduct(3)
      }
    }
  }
}


// vim: set ts=4 sw=4 et:
