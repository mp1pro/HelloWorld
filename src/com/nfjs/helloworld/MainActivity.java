package com.nfjs.helloworld;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.nfjs.helloworld.db.DbAdapter;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Button b = (Button) findViewById(R.id.hello_button);
        b.setOnClickListener(new View.OnClickListener() {
            
            @Override
            public void onClick(View v) {
                sayHello(v);
            }
        });
    }
    
    public void sayHello(View view) {
        EditText et = (EditText) findViewById(R.id.name);
        String name = et.getText().toString();
        DbAdapter dba = new DbAdapter(this);
        dba.open();
        dba.insertName(name);
        // Toast.makeText(this, "Hello, " + name + "!", Toast.LENGTH_LONG).show();
        Intent hello = new Intent(this, WelcomeActivity.class);
        hello.putExtra("name", name);
        startActivity(hello);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}
