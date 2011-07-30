package pwalsh.cache

import scala.actors.Actor
import scala.actors.Actor._
import scala.collection.mutable.ListBuffer
import scala.collection.mutable.HashMap

/* For now, I'm just caching key: Long and value: ListBuffer[Long]
*  TODO: make types generic so that type is specified on
*  instantiation, but implementation is generic
*/
case class CacheStore(val key: Long, val value: ListBuffer[Long])
case class CacheGet(val key: Long)
case class CacheContains(val key: Long)
//case object CacheStop
case object CacheClear

class Cacher extends Actor {
  var cache=HashMap.empty[Long,ListBuffer[Long]]
  def act() {
    loop {
      react {
        case CacheStore(key, value) =>
          cache += (key -> value)

        case CacheGet(key) => {
          if (cache contains key)
            reply(cache(key))
          else
            reply(None)
        }

        case CacheContains(key) =>
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
