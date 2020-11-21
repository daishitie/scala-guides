package com.daishitie

object PatternMatching extends App {

  // For spacing
  println()
  println(
    Console.CYAN + Console.BOLD + "Pattern Matching examples:" + Console.RESET
  )

  // Switch expression
  // Pattern match is an EXPRESSION
  // Pattern matching is equivalent to switch
  val anInteger = 55
  val order = anInteger match {
    case 1 => "First"
    case 2 => "Second"
    case 3 => "Third"
    case _ => anInteger + "th"
  }
  println(order)

  // Case class decomposition
  case class Person(name: String, age: Int)
  // Equivalent to Person.apply("Yuzaki Tsukasa", 16)
  val Tsukasa = Person("Yuzaki Tsukasa", 16)
  val personGreeting = Tsukasa match {
    case Person(name, age) => s"Hi, my name is $name and I am $age years old"
    case _                 => "Not a valid person"
  }
  println(personGreeting)

  // Deconstructing tuples
  val aTuple = ("Tonikaku Kawaii", "Romance, Comedy")
  val animeDescription = aTuple match {
    case (title, genre) => s"$title belongs to the genre $genre"
    case _              => "Not an anime"
  }
  println(animeDescription)

  // Decomposing lists
  val aList = List(1, 2, 3)
  // If pattern matching doesn't match anything, it will throw a MatchError
  // Always add _ at the end of case
  // Pattern matching will try all cases in sequence
  val listDescription = aList match {
    case List(_, 2, _) => "List containing 2 on its seconds position"
    case _             => "Unknown list"
  }
  println(listDescription)

  println()

}
