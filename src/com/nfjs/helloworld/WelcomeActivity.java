package com.nfjs.helloworld;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class WelcomeActivity extends Activity {
    private ListView list;
    private GetAllNamesTask task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        Intent input = this.getIntent();
        String name = input.getExtras().getString("name");
        TextView output = (TextView) findViewById(R.id.welcome_text);
        output.setText("Hello, " + name + "!");
        
        list = (ListView) findViewById(R.id.name_list);
        
        task = new GetAllNamesTask(this);
        task.execute();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.welcome, menu);
        return true;
    }
    
    public void showList(List<String> names) {
        // Build the adapter with whatever the current events are
        ArrayAdapter<String> arrayAdapter =
                new ArrayAdapter<String>(
                this, 
                android.R.layout.simple_list_item_1, 
                names);
        list.setAdapter(arrayAdapter);
    }

    public void removeTask() {
        if (task != null) {
            task.cancel(true);
        }
        task = null;
    }

}
