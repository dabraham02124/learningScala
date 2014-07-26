import scala.collection.mutable.ArrayBuffer
import scala.util.Random

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
