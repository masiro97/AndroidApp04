package com.android.masiro.proj041;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.startmenu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.activity1){
            Intent intent1  = new Intent(StartActivity.this,MainActivity.class);
            startActivity(intent1);

        }

        if(item.getItemId() == R.id.activity2){

            Intent intent2  = new Intent(StartActivity.this,Main2Activity.class);
            startActivity(intent2);

        }
        return super.onOptionsItemSelected(item);
    }
}
