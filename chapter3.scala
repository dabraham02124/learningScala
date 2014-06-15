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


// exercises


def randomArray(a : Array[Int]) : Array[Int] = {
  val b = ArrayBuffer[Int]()
  val random = new Random()

  for (i <- 0 until a.length) {
    b.append(random.nextInt(a.length))
  }
  b.toArray
}

