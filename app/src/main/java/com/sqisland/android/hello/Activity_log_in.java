package com.sqisland.android.hello;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

public class Activity_log_in extends Activity {

  private static short Attempt_cnt = 3;

  String name,password;

  String registeredName;
  String registeredPassword;

  EditText inputName;
  EditText inputEmail;

  Button log_in_button;
  Button to_register_button;

  public static final int REQUEST_CODE = 1014;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_log_in_l);

    inputName = (EditText) findViewById(R.id.inputName);
    inputEmail = (EditText) findViewById(R.id.inputPassword);
    log_in_button = (Button) findViewById(R.id.login_button);
    to_register_button = (Button) findViewById(R.id.to_register_button);

    log_in_button.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        // record user name and password on log-in
        name = inputName.getText().toString();
        password = inputEmail.getText().toString();

        // use for debugging
        // showToast(name);
        // showToast(password);

        if (name.equals(registeredName) && password.equals(registeredPassword))
        {
          // start main view activity
          Intent open_main_view = new Intent(Activity_log_in.this, Activity_main_view.class);
          startActivity(open_main_view);
        }
        else
        {
          Attempt_cnt--;

          if (Attempt_cnt == 0)
          {
            log_in_button.setEnabled(false);
            finish();
          }
          else
          {
            // use for debugging number of attempts left
            showToast("Log-in failed try again!");
            showToast(String.valueOf(Attempt_cnt));
          }
        }

      }
    });

    to_register_button.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view){
        Intent open_register = new Intent(Activity_log_in.this, Activity_register.class);
//        startActivity(open_register);
        startActivityForResult(open_register, REQUEST_CODE);
      }
    });
  }

  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
      switch (requestCode) {
          case REQUEST_CODE:
              if (resultCode == Activity.RESULT_OK)
              {
                  // if the user entered details on registration, save to local variables
                  registeredName = Activity_register.getUserName(data);
                  registeredPassword = Activity_register.getUserPassword(data);

                  //showToast(registeredName);
                  //showToast(registeredPassword);
              }
              else
              {
                  showToast("Failed");
              }
      }
  }

  public void showToast(String text)
  {
    Toast.makeText(Activity_log_in.this, text, Toast.LENGTH_SHORT).show();
  }
}
