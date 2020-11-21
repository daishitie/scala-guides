package com.daishitie

object ObjectOrientation extends App {

  // For spacing
  println()
  println(
    Console.CYAN + Console.BOLD + "Object Orientation examples:" + Console.RESET
  )

  // Class and instance
  class Animal {
    // Define fields
    val age: Int = 0
    // Define methods
    def eat() = println("I'm eating")
  }

  val anAnimal = new Animal

  // Inheritance
  // Contructor definition
  class Dog(val name: String) extends Animal
  val aDog = new Dog("Lassie")

  // Contructor arguments are NOT fields: need to put a val before the construtor argument
  println(aDog.name)

  // subType polymorphism
  val aDeclaredAnimal: Animal = new Dog("Hachi")
  // The most drived method will be called at runtime
  aDeclaredAnimal.eat()

  // Abstract class
  abstract class WalkingAnimal {
    val hasLegs =
      true // By default public, can restrict by adding private or protected
    def walk(): Unit
  }

  // "interface" = ultimate abstract type
  trait Carnivore {
    def eat(animal: Animal): Unit
  }

  trait Philosopher {
    def ?!(thought: String): Unit // valid method name
  }

  // single-class inheritance, multi-trait "mixing"
  class Crocodile extends Animal with Carnivore with Philosopher {
    override def eat(animal: Animal): Unit = println("I am eating you, animal!")

    override def ?!(thought: String): Unit = println(
      s"I was thinking: $thought"
    )
  }

  val aCrocodile = new Crocodile

  // infix notation = object method argument, only available for methods with ONE argument
  // Equivalent to aCrocodile.eat(aDog)
  aCrocodile eat aDog
  aCrocodile ?! "What if we could fly?"

  // Operators in Scala are actually methods
  val basicMath = 1 + 2
  val anotherBasicMath = 1.+(2)

  // Anonymous classes
  val dinosaur = new Carnivore {
    override def eat(animal: Animal): Unit = println(
      "I am a dinosaur so I can eat pretty much anything"
    )
  }

  /** Anonymous classes
    * What you tell the compiler:
    * class Carnivore_Anonymous_35728 extends Carnivor {
    *  override def eat(animal: Animal): Unit = println("I am a dinosaur so I can eat pretty much anything")
    * }
    *
    * val dinosaur = new Carnivore_Anonymous_35728
    */

  // Singleton object
  // the only instance of the MySingleton type
  object MySingleton {
    val mySpecialValue = 53278
    def mySpecialMethod(): Int = 5327
    def apply(x: Int): Int = x + 1
  }

  MySingleton.mySpecialMethod()
  MySingleton.apply(65)
  MySingleton(65) // Equivalent

  // companions - companion object
  object Animal {
    // companion can access each other's private fields or methods
    // singleton Animal and instance of Animal are different things
    val canLiveIndefinitely = false
  }

  val animalsCanLiveForever =
    Animal.canLiveIndefinitely // "static" fields or methods

  /** case classes = lightweight data structure with some boilerplate
    * - sensible equals and hash code
    * - serialization
    * - companion with apply
    * - pattern matching
    */

  case class Person(name: String, age: Int)

  // may be constructed without new
  val bob = Person("Bob", 54) // Person.apply("Bob", 54)

  // exceptions
  try {
    // code that can throw
    val x: String = null
    x.length()
  } catch {
    case e: Exception => "some faulty error message"
  } finally {
    // execute some code no matter what
  }

  // generics
  abstract class MyList[T] {
    def head: T
    def tail: MyList[T]
  }

  // using a generic with a concrete type
  val aList: List[Int] = List(1, 2, 3) // List.apply(1,2,3)
  val first = aList.head // int
  val rest = aList.tail
  val aStringList = List("hello", "scala")
  val firstString = aStringList.head // string

  // Point #1: in Scala we usually operate with IMMUTABLE values or objects
  // Any modification to an object must return ANOTHER object
  // Benefits:
  // 1) works miracles in multithreaded or distributed environment
  // 2) helps making sense of the code ("reasoning about")
  val reversedList = aList.reverse // returns a NEW list

  // Point #2: Scala is closest to the Object Oriented ideal

  println()

}
