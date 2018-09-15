package com.sqisland.android.hello;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ListItem extends Activity {

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
                setResult(Activity.RESULT_OK, new_intent);

                // return to the log-in screen and delete current activity
                finish();
            }
        });

    }
}
