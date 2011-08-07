package pwalsh.cache

import scala.actors.Actor
import scala.actors.Actor._
import scala.collection.mutable.HashMap

case class CacheStore[A, B](val key: A, val value: B)
case class CacheGet[A](val key: A)
case class CacheContains[A](val key: A)
//case object CacheStop
case object CacheClear

class Cacher[A,B] extends Actor {
  var cache=HashMap.empty[A,B]
  def act() {
    loop {
      react {
        case CacheStore(key:A, value:B) =>
          cache += (key -> value)

        case CacheGet(key: A) => {
          if (cache contains key)
            reply(cache(key))
          else
            reply(None)
        }

        case CacheContains(key: A) =>
          reply(cache contains key)

        /*case CacheStop =>
          exit()*/

        case CacheClear => cache.clear

        case unknown => {
          println("got an unknown message: "+unknown)
          reply(None)
        }
      }
    }
  }
}
object Cacher {
  def apply[A,B] = new Cacher[A,B]()
}

