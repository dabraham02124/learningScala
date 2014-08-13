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

randomArray(Array(1,1,1,1))

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

swapArray(Array(1,2,3,4,5))

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

swapArrayForYield(Array(1,2,3,4,5))
swapArrayForYield(Array(1,2,3,4,5,6))

println
println("exercise 4")
//ex 4 return a new array that has the values grouped by positive/negative, 
//but in original order within that.
//It feels like there should be a more functional way to do this, but it 
//works, and it only goes through the array once (and two thirds), so I'm 
//letting it go for now
//
//I could just count the zeros and append that many, but that seems a little like cheating...
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

//this is cleaner, but it goes through the array three times (and two thirds)
def groupArray2(a : Array[Int]) : Array[Int] = {
  val pos = a.filter(x => x > 0)
  val zer = a.filter(x => x == 0)
  val neg = a.filter(x => x < 0)

  pos ++ zer ++ neg
}


groupArray(Array(-11, 2, 3, -4, -86, -1, 7, 0, 44, 0, -9))
groupArray2(Array(-11, 2, 3, -4, -86, -1, 7, 0, 44, 0, -9))

println
println("exercise 5")
//How do you compute the average of an Array[Double]
//doesn't worry about overflow or length > maxInt
def averageArray(a : Array[Double]) : Double = {
  a.fold(0.0){_+_} / a.length
}

//this one potentially loses precision, but can't overflow
def averageArray2(a : Array[Double]) : Double = {
  a.map(_/a.length).fold(0.0){_+_}
}

averageArray(Array(3.14, 15.2))
averageArray(Array(3.14, 15.2, -18.34))
averageArray(Array(3.14, 15.2, -18.34, 0))
averageArray(Array(3.14, 15.2, -18.34, 0, 49.4533))

averageArray2(Array(3.14, 15.2))
averageArray2(Array(3.14, 15.2, -18.34))
averageArray2(Array(3.14, 15.2, -18.34, 0))
averageArray2(Array(3.14, 15.2, -18.34, 0, 49.4533))
