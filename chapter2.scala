def signum(n : Int) = {
  if (n == 0) 0 else if (n > 0) 1 else -1
}

def loopExample(n : Int) {
  for (i <- 0 to n) println(n - i)
}

def unicodeProduct(s : String) = {
  var r = 1
  for (ch <- s) {
    println(ch.toInt) 
    r = r * ch
  }
  r
}
