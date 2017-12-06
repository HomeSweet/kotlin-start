package team.uptech.webinarsample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Danil Kravchenko on 07.12.2017.
 */

public class JavaActivity extends AppCompatActivity {
  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
  }

  public static void doSomething() {
    System.out.printf("hello");
  }
}
