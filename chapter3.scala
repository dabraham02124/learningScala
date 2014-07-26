import scala.collection.mutable.ArrayBuffer
import scala.util.Random


val b = ArrayBuffer [Int]()
b += 1
b += (1,2,3,5)
b ++= Array(8,13,21)
b.trimEnd(5)                ;b.toArray

b.insert(2,6)       	    ;b.toArray
b.insert(2,7,8,9)    	    ;b.toArray
b.remove(2)	     	    ;b.toArray
b.remove(2,3)		    ;b.toArray

for (i <- 0 until b.length)
  println(("b["+i+"] = "+b(i)))
0 until 10
0.until(10)
0 until (10,2)
(0 until 10).reverse
for (elem <- b)
  println(elem)


val a = Array(2,3,5,7,11)
val result = for (elem <- a) yield 2 * elem
val result2 = for (elem <- a if elem % 2 == 0) yield 2 * elem //this one fixes a bug in the book
a.filter(_ %2 == 0).map(2*_)
a filter {_%2 == 0} map {2*_}
Array(1,2,3,4).map(2*_).fold(0){_ + _}

//page 34
Array(1,7,2,9).sum //yields 19
Array("Mary","had","a","little","lamb").max //yields little (off of size, I think)

val c = Array(1,7,2,9)
val cSorted = c.sortWith(_ < _) //it uses sorted in the book, doesn't work in my scala...
val cSorted2 = c.sorted
scala.util.Sorting.quickSort(c)  ;c.toArray

b.mkString(" and ")
b.mkString("<",",",">")

//page 35
a.toString   //annoying java toString
b.toString   //useful scala toString because it's not an Array...
