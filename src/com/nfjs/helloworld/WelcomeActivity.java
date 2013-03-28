package com.nfjs.helloworld;

import java.util.List;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.nfjs.helloworld.db.DbAdapter;

public class WelcomeActivity extends FragmentActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
    }
}
