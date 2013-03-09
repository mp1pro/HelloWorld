package com.nfjs.helloworld;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.nfjs.helloworld.db.DbAdapter;

public class WelcomeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        Intent input = this.getIntent();
        String name = input.getExtras().getString("name");
        TextView output = (TextView) findViewById(R.id.welcome_text);
        output.setText("Hello, " + name + "!");
        
        ListView list = (ListView) findViewById(R.id.name_list);
        DbAdapter adapter = new DbAdapter(this);
        adapter.open();
        List<String> names = adapter.getAllNames();

        ArrayAdapter<String> arrayAdapter =
                new ArrayAdapter<String>(
                this, 
                android.R.layout.simple_list_item_1, 
                names);
        list.setAdapter(arrayAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.welcome, menu);
        return true;
    }

}
