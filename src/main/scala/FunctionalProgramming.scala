package com.daishitie

object FunctionalProgramming extends App {

  // For spacing
  println()
  println(
    Console.CYAN + Console.BOLD + "Functional Programming examples:" + Console.RESET
  )

  // Scala is Object Oriented
  // Output: Yuzaki Tsukasa have aged 16 years
  class Person(name: String) {
    def apply(age: Int) = println(s"$name have aged $age years")
  }
  val tsukasa = new Person("Yuzaki Tsukasa")
  // INVOKING tsukasa as a function
  // Equivalent to tsukasa.apply(16)
  tsukasa(16)

  /** Scala runs on the JVM
    * Functional programming:
    * - compose functions
    * - pass function as args
    * - return function as results
    *
    * Conclusion: FunctionX = Function1, Function2, Function3, ... Function22
    */

  // Output: 24
  val simpleIncrementer = new Function1[Int, Int] {
    override def apply(arg: Int): Int = arg + 1
  }

  // simpleIncrementer.apply(23)
  // Defined a function!
  //
  println(simpleIncrementer(23))

  /** All Scala functions are instances of these function_x types
    */

  // Function with 2 arguments and a string return type
  // Output: I love Tonikaku Kawaii
  val stringConcat = new Function2[String, String, String] {
    override def apply(arg1: String, arg2: String): String = arg1 + arg2
  }
  println(stringConcat("I love", " Tonikaku Kawaii"))

  // Syntax sugras
  // Output: 8
  val doubler: Int => Int = (x: Int) => 2 * x
  println(doubler(4))

  /** Equivalent to the much longer:
    * val doubler: Function1[Int, Int] = new Function1[Int, Int] {
    *  override def apply(x: Int) = 2 * x
    * }
    */

  // higher-order functions: take function as args or return function as results
  // Output: List(2, 3, 4)
  val aMappedList: List[Int] = List(1, 2, 3).map(_ + 1)
  println(aMappedList)

  // Flat map use very often in Scala
  // Output: List(1, 2, 2, 4, 3, 6)
  // Alternative syntax, same as .flatMap(x => List(x, 2 * x))
  val aFlatMappedList = List(1, 2, 3).flatMap { x =>
    List(x, 2 * x)
  }
  println(aFlatMappedList)

  // Equivalent to x => x <= 3
  // Output: List(1, 2, 3, 4)
  val aFilterList = List(1, 2, 3, 4, 5).filter(_ <= 4)
  println(aFilterList)

  // All pairs between the numbers 1, 2, 3 and the letters a, b ,c
  // Output: List(1-a, 1-b, 1-c, 2-a, 2-b, 2-c, 3-a, 3-b, 3-c)
  val allPairs = List(1, 2, 3).flatMap { number =>
    List("a", "b", "c").map { letter =>
      s"$number-$letter"
    }
  }
  println(allPairs)

  // For comprehensions
  // Output: List(1-a, 1-b, 1-c, 2-a, 2-b, 2-c, 3-a, 3-b, 3-c)
  val alternativePairs = for {
    number <- List(1, 2, 3)
    letter <- List("a", "b", "c")
  } yield s"$number-$letter"
  // Equivalent to the map or flatMap chain above
  println(alternativePairs)

  /** Collections
    */

  //  Lists
  val aList = List(1, 2, 3, 4, 5)
  val firstElement = aList.head
  val rest = aList.tail
  // Output: List(0, 1, 2, 3, 4, 5)
  val aPrependedList = 0 :: aList
  // Output: List(0, 1, 2, 3, 4, 5, 6)
  val anExtendedList = 0 +: aList :+ 6

  // Sequences
  // Equivalent to Seq.apply(1, 2, 3)
  val aSequence: Seq[Int] = Seq(1, 2, 3)
  // The element of index 1
  // Output: 2
  val accessedElement = aSequence(1)

  // Vectors
  // For large datas: Fast Seq implementation
  val aVector = Vector(1, 2, 3, 4, 5)

  // Sets
  // No duplicates
  // Output: Set(1, 2, 3, 4)
  val aSet = Set(1, 2, 3, 4, 1, 2, 3)
  // Output: false
  // No 5 in aSet
  val setHas = aSet.contains(5)
  // Output: Set(1, 2, 3, 4, 5)
  val anAddedSet = aSet + 5
  // Output: Set(1, 2, 4)
  val aRemoveSet = aSet - 3

  // Ranges
  val aRange = 1 to 50000
  // Output:List(2, 4, 6, 8, 10, ... 4000)
  val twoByTwo = aRange.map(x => 2 * x).toList
  println(Console.GREEN + twoByTwo + Console.RESET)

  // Tuples
  // Groups of values under the same value
  val aTuple = ("Yunomi", "JPop", 2020)

  // Maps
  val aCharacter: Map[String, Int] = Map(
    "Yuzaki Tsukasa" -> 16,
    "Yuzaki Nasa" -> 18
  )
  println(aCharacter)

  println()
}
