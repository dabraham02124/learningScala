//4.1
val scores = Map("Alice" -> 10, "Bob" -> 5, "Charlie" -> 7)
val scoresMutable = scala.collection.mutable.Map("Alice" -> 10, "Bob" -> 5, "Charlie" -> 7)

//4.2
scores("Bob")
val bobScore = if (scores.contains("Bob")) scores("Bob") else 0
val bobScore2 = scores.getOrElse("Bob", 0)

//4.3
scoresMutable("Bob") = 45
scoresMutable("David") = 453
scoresMutable
scoresMutable += ("Elizabeth" -> 14, "Felicia" -> 22)
scoresMutable -= "Alice"
scoresMutable

val scores2 = scores + ("Bob" -> 543, "Frederic" ->123)

//4.4 iterating over map
for (v <- scores.values) println(v)
for (v <- scores.keySet) println(v)
for ((k,v) <- scores2) yield (v,k)

//4.5 sorted maps
val sortedScores = scala.collection.immutable.SortedMap("Alice" -> 10, "Bob" -> 5, "Charlie" -> 7)
val months = scala.collection.mutable.LinkedHashMap("January" -> 1, "February" -> 2)

//4.6 java interop
import scala.collection.JavaConversions.mapAsScalaMap
val mapFromJava : scala.collection.mutable.Map[String, Int] = new java.util.TreeMap[String, Int]
