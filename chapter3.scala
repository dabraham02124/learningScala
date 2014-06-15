import scala.collection.mutable.ArrayBuffer
import scala.util.Random

def randomArray(a : Array[Int]) : Array[Int] = {
  val b = ArrayBuffer[Int]()
  val random = new Random()

  for (i <- 0 until a.length) {
    b.append(random.nextInt(a.length))
  }
  b.toArray
}
