package team.uptech.webinarsample

import org.junit.Test

/**
 * EXTENSION FUNCTIONS
 *
 * Что такое extension functions?
 * Как объявить extension function?
 * Extension properties
 * Extension function scope
 * Extension function and Java
 */
class ExtensionFunctions {
  @Test
  fun testDeclare() {
    //Declare extension func
    val clazz = SomeClassWeWantToExtend()
    clazz.doMagic()
    clazz.makeMagic()
    //Declare extension func

  }

  @Test
  fun testRealExample() {
    //Real example
    val list = mutableListOf(1, 2, 3, 4, 5)
    list.swap(0, 3)
    println(list)
    //Real example
  }

  @Test
  fun testInheritance() {
    val b = B()
    callExtension(b)
  }

  @Test
  fun testOverloading() {
    val clazz = SomeClassWeWantToExtend()
    clazz.doMagic(3)
  }

  @Test
  fun testNullable() {
    var clazz: SomeClassWeWantToExtend?

    clazz = null
    clazz.doMagicNullable()

    clazz = SomeClassWeWantToExtend()

    clazz.doMagicNullable()
  }

  @Test
  fun testProperty() {
    val list = listOf(1, 2, 3, 4)
    println(list.lastIndex)
  }

  @Test
  fun testCompanion() {
    SomeClassCompanion.doSomething()
    SomeClassCompanion.Companion.doAnother()
    SomeClassCompanion.doAnother()
  }

  @Test
  fun testScope() {
    class C() {

    }

    class D() {

      fun C.scope() {
        println("inside class")
      }

      fun call(c: C) {
        c.scope()
      }

    }

    val d = D()

    d.call(C())
  }

  @Test
  fun testJavaAndExtension() {
    fun StringBuffer.print() {
      println(this.toString())
    }

    val stringBuffer = StringBuffer()
    stringBuffer.append("buffer")

    stringBuffer.print()

    //fun Uri.Companion.doSomething() { ... } can't do this
  }
}

class SomeClassWeWantToExtend {
  fun doMagic() {
    println("magic")
  }
}

//1 Declare extension func
fun SomeClassWeWantToExtend.makeMagic() {
  doMagic()
  println("we've made magic")
}
//1 Declare extension func

//Shadow extension func
fun SomeClassWeWantToExtend.doMagic() {
  println("this magic is shadowed")
}
//Shadow extension func

//1 Real example
fun <T> MutableList<T>.swap(index: Int, index2: Int) {
  val tmp = this[index]
  this[index] = this[index2]
  this[index2] = tmp
}
//1 Real example


//2 Inheritance
open class A

class B : A()

fun A.doSomething() {
  println("this is A")
}

fun B.doSomething() {
  println("this is B")
}

fun callExtension(a: A) {
  a.doSomething()
}
//Inheritance

//Overloading
fun SomeClassWeWantToExtend.doMagic(times: Int) {
  println("magic $times")
}
//Overloading

//Nullable
fun SomeClassWeWantToExtend?.doMagicNullable() {
  if (this != null) println("magic is not null") else println("null")
}
//Nullable

//Property
val <T> List<T>.lastIndex: Int
  get() = size - 1
//Property

////Companion
class SomeClassCompanion() {
  companion object {
    fun doSomething() {
      println("I am companion")
    }
  }
}

fun SomeClassCompanion.Companion.doAnother() {
  println("extended")
}
//Companion

