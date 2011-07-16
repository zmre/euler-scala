object ProblemSetExample {
  var cache:collection.mutable.Set[Long]=collection.mutable.Set()
    cache.clear
    if ( cache(num) )
        return ListBuffer(num)
    cache += num
}
