package com.sqisland.android.hello;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ListItem extends Activity {

    int pos_to_return = 1;
    public static final String RETURN_VAL = "List Item Activity - value";

    Button Return_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_item);

        Return_button = (Button) findViewById(R.id.return_back);

        Return_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent new_intent = new Intent();
                new_intent.putExtra(RETURN_VAL, pos_to_return);
                setResult(Activity.RESULT_OK, new_intent);

                // return to the log-in screen and delete current activity
                finish();
            }
        });
    }

    public static int getValue(Intent intent){
        return intent.getIntExtra(RETURN_VAL, 0);
    }

}
