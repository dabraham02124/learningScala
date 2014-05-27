def signum(n : Int) = {
  if (n == 0) 0 else if (n > 0) 1 else -1
}

def loopExample(n : Int) {
  for (i <- 0 to n) println(n - i)
}

def unicodeProduct(s : String) = {
  var r:Long = 1
  for (ch <- s) {
    r = r * ch
  }
  r
}

def unicodeProductRecursive(s : String):Long = {
  if ("".equals(s))
    return 1L
  s.take(1).charAt(0) * uPR(s.drop(1))
}

def exp(x: Int, n: Int):Float = {
  if (n == 0) {
    1
  } else if (n == 1) {
    x
  } else if (n < 1) {
    1 / exp(x, -n)
  } else if (n%2 == 0) {
    var n2 = n/2
    var subP = exp(x,n2)
    subP * subP
  } else {
    x * exp(x,n-1)
  }
}
