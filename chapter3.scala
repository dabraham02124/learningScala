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


// exercises
println
println

println
println("exercise 1")
//ex 1 create a random array of n integers in [0..n)
def randomArray(a : Array[Int]) : Array[Int] = {
  val b = ArrayBuffer[Int]()
  val random = new Random()

  for (i <- 0 until a.length) {
    b.append(random.nextInt(a.length))
  }
  b.toArray
}
val d = randomArray(Array(1,1,1,1))

println
println("exercise 2")
//ex 2 create a new array based on first array by swapping pairs w/in the array
def swapArray(a : Array[Int]) : Array[Int] = {
  val swapped = ArrayBuffer[Int] ()
  for (i <- 1 to a.length by 2) {
    if (i >= a.length) {
      swapped += a(a.length-1)
    } else {
      swapped += a(i) += a(i-1)
    }
  }
  swapped.toArray
}
val e = swapArray(Array(1,2,3,4,5))

println
println("exercise 3")
//ex 3 create a new array based on first array by swapping pairs w/in the array, this time use for/yield
def swapArrayForYield(a : Array[Int]) : Array[Int] = {
  val swapped = for (i <- 0 until a.length) yield {
    if (0 == i % 2) {
      a(if (i+1 <= a.length - 1) i + 1 else i)
    } else {
      a(i - 1)
    }
  }

  swapped.toArray
}

val f = swapArrayForYield(Array(1,2,3,4,5))
val g = swapArrayForYield(Array(1,2,3,4,5,6))

println
println("exercise 4")
//ex 4 return a new array that has the values grouped by positive/negative, but in original order within that
//this feels like there should be a more functional way to do this, but it works, and it only goes through the 
//array once (and two thirds), so I'm letting it go for now
def groupArray(a : Array[Int]) : Array[Int] = {
  val pos = ArrayBuffer[Int]()
  val zer = ArrayBuffer[Int]()
  val neg = ArrayBuffer[Int]()

  for (elem <- a) {
    if (0 < elem) {
      pos += elem
    } else if (0 == elem) {
      zer += elem
    } else {
      neg += elem
    }
  }

  pos.appendAll(zer)
  pos.appendAll(neg)
  pos.toArray
}

val tbg = Array(-11, 2, 3, -4, -86, -1, 7, 0, 44, -9)
val i = groupArray(tbg)
