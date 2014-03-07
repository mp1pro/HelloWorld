package com.nfjs.helloworld.test;

import java.util.List;

import android.test.AndroidTestCase;

import com.nfjs.helloworld.db.DbAdapter;

public class DbAdapterTest extends AndroidTestCase {
    private DbAdapter dba;
    
    public void setUp() {
        dba = new DbAdapter(getContext());
        dba.open();
    }

    public void testInsertAndGetAllNames() {
        dba.insertName("Fred");
        dba.insertName("Barney");
        List<String> names = dba.getAllNames();
        assertTrue(names.contains("Fred"));
        assertTrue(names.contains("Barney"));
        dba.deleteAllNames();
    }

    public void testDeleteName() {
        int count = dba.getAllNames().size();
        dba.insertName("Fred");
        assertEquals(count + 1, dba.getAllNames().size());
        
        dba.deleteName("Fred");
        assertEquals(count, dba.getAllNames().size());
    }

}
