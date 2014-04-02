package com.nfjs.helloworld;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
	private static final String TAG = "MainActivity";
    private Button b;
    private EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        et = (EditText) findViewById(R.id.name);
        b = (Button) findViewById(R.id.hello_button);
        b.setOnClickListener(new View.OnClickListener() {
            
            @Override
            public void onClick(View v) {
                sayHello(v);
            }
        });
    }
    
    public void sayHello(View view) {
        String name = et.getText().toString();
        // Toast.makeText(this, "Hello, " + name + "!", Toast.LENGTH_LONG).show();
        Intent hello = new Intent(this, WelcomeActivity.class);
        hello.putExtra("name", name);
        startActivity(hello);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    		switch (item.getItemId()) {
			case R.id.action_settings:
				Log.d(TAG, "menu settings selected");
				return true;

			default:
				return super.onOptionsItemSelected(item);
			}
    }
}
