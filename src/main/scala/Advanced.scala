package com.daishitie

import scala.util.{Try, Success, Failure}
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

object Advanced extends App {

  // For spacing
  println()
  println(
    Console.CYAN + Console.BOLD + "Pattern Matching examples:" + Console.RESET
  )

  /** Lazy evaluation
    */
  // Useful in infinite collections
  lazy val aLazyValue = 2
  lazy val lazyValueWithSideEffect = {
    println("I am so very lazy!")
    43
  }

  val eagerValue = lazyValueWithSideEffect + 1

  /** Pseudo collections
    */
  // Option, Try
  def methodWhichCanReturnNull(): String = "Hello, Scala"
  // Some("Hello, Scala")
  val anOption = Option(methodWhichCanReturnNull())
  // option = "collection" which contains at most one element
  // Some(value) or None

  // Guard against null
  val stringProcessing = anOption match {
    case Some(string) => s"I have obtained a valid string $string"
    case None         => "I obtained nothing"
  }

  // a try = "collection" with either a value if the code went well, or an exception if the code throw one
  def methodWhichCanThrowException(): String = throw new RuntimeException
  val aTry = Try(methodWhichCanThrowException())
  val anotherStringProcessing = aTry match {
    case Success(validValue) => s"I have obtained a valid string $validValue"
    case Failure(e)          => s"I have obtained an exception $e"
  }
  // map, flatMap, filter

  /** Evaluate something on another thread
    * (asynchronous programming)
    */

  val aFuture = Future {
    println("Loading...")
    Thread.sleep(1000)
    println("I have computed a value.")
    67
  }
  Thread.sleep(2000)
  // Future is a "collection" which contains a value when it's evaluated
  // Future is composable with map, flatMap, and filter

  /** Implicits basics
    * A powerful features of scala compiler
    */

  // Use case #1: Implicit arguments
  def aMethodWithImplicitArgs(implicit arg: Int) = arg + 1
  implicit val myImplicitInt = 46
  // aMethodWithImplicitArgs(myImplicitInt)
  println(aMethodWithImplicitArgs)

  // Use case #2: Implicit conversions
  implicit class MyRichInteger(n: Int) {
    def isEven() = n % 2 == 0
  }
  // new MyRichInteger(23).isEven()
  // Use this carefully
  println(22.isEven())

  println()

}
