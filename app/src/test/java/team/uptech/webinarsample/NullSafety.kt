package team.uptech.webinarsample

import org.junit.Test

/**
 * Created by Danil Kravchenko on 07.12.2017.
 */
class NullSafety {
  @Test
  fun test() {
    var a : String = "string"
    //a = null - error

    var b : String? = "string"
    b = null

  }
}