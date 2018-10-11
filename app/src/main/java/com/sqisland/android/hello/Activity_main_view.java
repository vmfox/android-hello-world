package com.sqisland.android.hello;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Activity_main_view extends Activity {

    int pos;

    public static final int REQUEST_CODE = 1014;
    public static final String USER_LIST = "Activity_register - Registered User Name";

    EditText edit_text;
    ListView listView;
    Button Button;

    String selectedItem;

    ArrayList <String> ArrayList;
    ArrayAdapter <String> ArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_view_l);

        listView = (ListView) findViewById(R.id.text_list_view);
        Button = (Button) findViewById(R.id.add_text_button);
        edit_text = (EditText) findViewById(R.id.add_text_view);

        ArrayList = new ArrayList<>();
        ArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, ArrayList);

        listView.setAdapter(ArrayAdapter);
        listView.setOnItemClickListener(onItemClick);

        Button.setOnClickListener(new View.OnClickListener(){
          @Override
          public void onClick(View view) {
            ArrayList.add(edit_text.getText().toString());
            ArrayAdapter.notifyDataSetChanged();

            // use for debugging
            selectedItem = listView.getItemAtPosition(0).toString();
            showToast(selectedItem);
          }
        });
    }


    // redirect to the required activity
    private AdapterView.OnItemClickListener onItemClick = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            Intent open_list_view = new Intent(Activity_main_view.this, ListItem.class);
            open_list_view.putExtra(USER_LIST,listView.getItemAtPosition(i).toString());
            startActivityForResult(open_list_view,REQUEST_CODE);
        }
    };

    public void showToast(String text) {
        Toast.makeText(Activity_main_view.this, text, Toast.LENGTH_SHORT).show();
    }

    public void showToast(int value) {
        Toast.makeText(Activity_main_view.this, value, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case REQUEST_CODE:
                if (resultCode == Activity.RESULT_OK)
                {
                    // if the user entered details on registration, save to local variables
                    pos = ListItem.getValue(data);

                    showToast(pos);
                    
                    //showToast(registeredPassword);
                }
                else
                {
                    showToast("Failed");
                }
        }
    }


}
