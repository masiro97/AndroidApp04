package com.android.masiro.proj041;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    LinearLayout l;
    ImageView food;
    TextView t;
    Button back;
    int num =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        l = (LinearLayout)findViewById(R.id.linear1);
        food = (ImageView)findViewById(R.id.imageView);
        t = (TextView)findViewById(R.id.textView);
        back = (Button)findViewById(R.id.button);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                l.setBackgroundColor(Color.WHITE);
                food.setRotation(0);
                food.setScaleX(1);
                food.setScaleY(1);
                t.setVisibility(View.INVISIBLE);

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId()){
            case R.id.blue:
                l.setBackgroundColor(Color.BLUE);
                break;
            case R.id.yellow:
                l.setBackgroundColor(Color.YELLOW);
                break;
            case R.id.red:
                l.setBackgroundColor(Color.RED);
                break;
            case R.id.rotation1:
                num++;
                food.setRotation(num *30);
                break;
            case R.id.expand1:
                food.setScaleX(2);
                food.setScaleY(2);
                break;
            case R.id.title1:
                t.setVisibility(View.VISIBLE);
                break;
            case R.id.spaghetti:
                food.setImageResource(R.drawable.s);
                t.setText("새콤한 스파게티");
                item.setChecked(true);
                break;
            case R.id.chicken:
                food.setImageResource(R.drawable.c);
                t.setText("겁나 맛있는 치킨");
                item.setChecked(true);
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
