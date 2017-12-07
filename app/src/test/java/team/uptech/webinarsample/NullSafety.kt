package team.uptech.webinarsample

import org.junit.Test

/**
 * Created by Danil Kravchenko on 07.12.2017.
 */
/**
 * Null Safety
 */
class NullSafety {
  @Test
  fun testDeclaration() {

    var a: String = "string"
    //a = null - error

    var b: String? = "dddd"

    a.length
    // b.length - error

    val length = if (b != null) {
      b.length
    } else -1
  }

  class University(val department: Department) {

    class Department(val user: User) {

      class User(val name: String)

    }
  }

  var univercity: University? = null

  @Test
  fun testSafecalls() {

    var b: String? = "dddd"

    //b.length - error

    b?.length

    univercity = University(University.Department(University.Department.User("danil")))

    univercity?.department?.user?.name

  }

  @Test
  fun testPrintIfnotNull() {

    var b: String? = "dddd"
    b?.let { println(it) }


    val c: String? = null
    val list = listOf(b, "string", null, "another", c)
    list.forEach { item ->
      item?.let { println(it) }
    }
  }

  @Test
  fun testElvis() {
    var b: String? = "dddd"

    val length = if (b != null) b.length else -1

    val length2 = b?.length ?: -1
  }

  @Test
  fun test() {

    var b: String? = null

    val length = b!!.length

    val a: String? = "string"

    val length2 = a!!.length
  }

  open class A {
    fun a() {
      print("a")
    }
  }

  class B : A() {
    fun b() {
      print("b")
    }
  }

  @Test
  fun testSmartCast() {

    val b = B()

    val a = b as? A

    a?.let {
      a.a()
    }
  }
}