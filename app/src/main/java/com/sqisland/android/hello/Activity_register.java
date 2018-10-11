package com.sqisland.android.hello;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class Activity_register extends Activity {

    String userNameRegistered, userPassword;
    public static final String USER_NAME_RESULT = "Activity_register - Registered User Name";
    public static final String USER_PASSWORD_RESULT = "Activity_register - Registered User Password";

    EditText inputUserName;
    EditText inputPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_l);

        inputUserName = (EditText) findViewById(R.id.userNameRegister);
        inputPassword = (EditText) findViewById(R.id.register_password);

        Button userRegister = (Button) findViewById(R.id.register_button);

        userRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // get data from the registry form
                userNameRegistered = inputUserName.getText().toString();
                userPassword = inputPassword.getText().toString();

                // pass data back
                Intent intent = new Intent();
                intent.putExtra(USER_NAME_RESULT, userNameRegistered);
                intent.putExtra(USER_PASSWORD_RESULT, userPassword);
                setResult(Activity.RESULT_OK, intent);

                // return to the log-in screen and delete current activity
                finish();
            }
        });
    }

    public static String getUserName(Intent intent){
        return intent.getStringExtra(USER_NAME_RESULT);
    }

    public static String getUserPassword(Intent intent){
        return intent.getStringExtra(USER_PASSWORD_RESULT);
    }
}
