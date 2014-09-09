//ex 1 set up a map of items and prices, then print that map with the
//prices at 10% off
val priceList = Map("doohickey" -> 10.0, "whatsit" -> 14.5, "thingammer"-> 19.95)

Console.println(priceList.keys.zip(priceList.values.map(_*0.9)))

//ex 2 write a program that reads words from a file, puts them into a
//map, then prints out the number of times each word occurs
val in = new java.util.Scanner(new java.io.File("sampleFile.txt"))
while (in.hasNext())

  in.next
