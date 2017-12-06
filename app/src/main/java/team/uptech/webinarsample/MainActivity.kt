package team.uptech.webinarsample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

//Companion object
class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
  }

  companion object {
    fun doSomething() {
      print("hello")
    }
  }
}
