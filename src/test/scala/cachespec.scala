package test.scala
import org.scalatest.Spec
import pwalsh.cache._

class CacheSpec extends Spec {
  describe("Cacher") {
    it("should remember and return a previously cached value") {
      val cacher=Cacher[Long,List[Long]]
      cacher.start
      cacher ! CacheStore(5, List(1,2,3))
      expect(List(1,2,3)) { cacher !? CacheGet(5) }
    }
    it("should accurately reply to CacheContains") {
      val cacher=new Cacher
      cacher.start
      cacher ! CacheStore(5, List(1,2,3))
      expect(true) { cacher !? CacheContains(5) }
      expect(false) { cacher !? CacheContains(4) }
    }
    it("should return None when fetching uncached value") {
      val cacher=new Cacher
      cacher.start
      cacher ! CacheStore(5, List(1,2,3))
      expect(None) { cacher !? CacheGet(4) }
    }
    it("should return None when fetching uncached value without having cached anything") {
      val cacher=new Cacher
      cacher.start
      expect(None) { cacher !? CacheGet(4) }
    }
    it("should fail if unknown message sent in") {
      val cacher=new Cacher
      cacher.start
      expect(None) { cacher !? "abc" }
    }
    it("should remember most recently cached value if multiple") {
      val cacher = new Cacher
      cacher.start
      cacher ! CacheStore(5, List(1,2,3))
      cacher ! CacheStore(5, List(4,5,6))
      expect(List(4,5,6)) { cacher !? CacheGet(5) }
    }
  }
}


// vim: set ts=4 sw=4 et:
