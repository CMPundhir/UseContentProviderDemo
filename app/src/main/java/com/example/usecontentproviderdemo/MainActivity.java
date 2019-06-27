package com.example.usecontentproviderdemo;

import android.database.Cursor;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    String[] permissions = new String[]{"com.example.mysqlite.READ_DATABASE","com.example.mysqlite.WRITE_DATABASE"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //ActivityCompat.requestPermissions(this,permissions,11);
    }


    public void useContentProvider(View view){
        String URL = "content://com.example.mysqlite.MyProvider";
        Uri students = Uri.parse(URL);
        Cursor cursor = getContentResolver().query(students, null, null, null, "name");
        if (cursor.moveToFirst()){
            do {
                User myUser = new User();
                myUser.setuId(cursor.getInt(0));
                myUser.setName(cursor.getString(1));
                myUser.setEmail(cursor.getString(2));
                myUser.setPassword(cursor.getString(3));
                Log.d("USERS",myUser.toString());
            }while (cursor.moveToNext());
        }
    }
}
