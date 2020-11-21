package com.daishitie

object Main extends App {

  // For spacing
  println()
  println(Console.CYAN + Console.BOLD + "Main examples:" + Console.RESET)

  // Defining a constant value
  val myAge: Int = 24

  // Types: Int, Boolean, Char, Double, Float, String
  // Type is optional and not preferred
  val aBoolean = false
  println(s"Boolean value is $aBoolean")

  // Strings and string operations
  val aString = "Yuzaki Tsukasa"
  val aComposedString = "Yuzaki" + " " + "Nasa"
  val anInterpolatedString = s"My age is $myAge"
  println(aString)
  println(aComposedString)
  println(anInterpolatedString)

  // Expression = structures that can be reduced to a value
  val anExpression = 2 + 3

  // If expression
  val ifExpression = if (myAge >= 16) "Not Minor" else "Minor"
  val chainedIfExpression = {
    if (myAge < 16) "Minor"
    else if (myAge < 20) "Not Minor"
    else if (myAge < 50) "Get A Life"
    else "Lmao, What Is Life"
  }

  // Code blocks
  val aCodeBlock = {
    // Definitions
    val aLocalValue = 13

    // Value of block is the value of the last expression
    aLocalValue + 3
  }
  println(aCodeBlock)

  // Define a function
  def myFunction(x: Int, y: String): String = {
    y + " age " + x
  }
  println(myFunction(16, "Yuzaki Tsukasa"))

  /** In Scala we don't use loops or iterations, we use RECURSION!
    * Iterations is discouraged in Scala
    */

  // Recursive functions
  def myFactorial(n: Int): Int = {
    if (n <= 1) 1
    else n * myFactorial(n - 1)
  }
  println(myFactorial(9))

  /** The Unit type = no meaningful value === "void" in other languages
    */

  // Type of SIDE EFFECTS
  println("I love Tonikaku Kawaii")

  def myUnitReturningFunction(): Unit = {
    println("I don't love returning Unit type")
  }

  // For spacing
  println()

}
