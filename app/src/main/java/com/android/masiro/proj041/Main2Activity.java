package com.android.masiro.proj041;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;


public class Main2Activity extends AppCompatActivity {

    TabHost tab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        setTitle("각종 계산기");
        tab = (TabHost)findViewById(R.id.tabhost);
        tab.setup();

        TabHost.TabSpec tab1 = tab.newTabSpec("a").setContent(new TabHost.TabContentFactory() {
            @Override
            public View createTabContent(String tag) {
                View view1 = View.inflate(Main2Activity.this,R.layout.bmi,null);
                Button btn = (Button)view1.findViewById(R.id.button1);
                final EditText e11 = (EditText)view1.findViewById(R.id.editText1);
                final EditText e12 = (EditText)view1.findViewById(R.id.editText2);
                final TextView t4 = (TextView)view1.findViewById(R.id.textView4);
                final TextView t7 = (TextView)view1.findViewById(R.id.textView7);

                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        float height = Float.parseFloat(e11.getText().toString())/100;
                        float weight = Float.parseFloat(e12.getText().toString());
                        float bmi = weight / (height * height);

                        t7.setText("BMI 지수: " + bmi);

                        if (bmi < 18.5) {
                            t4.setText("체중부족입니다");
                        } else if (bmi >= 18.5 && bmi < 23) {
                            t4.setText("정상체중입니다");
                        } else if (bmi >= 23 && bmi < 25) {
                            t4.setText("과체중입니다");
                        } else {
                            t4.setText("비만입니다");
                        }
                    }
                });
                return view1;
            }
        }).setIndicator("BMI 계산기");

        tab.addTab(tab1);

        TabHost.TabSpec tab2 = tab.newTabSpec("b").setContent(new TabHost.TabContentFactory() {
            @Override
            public View createTabContent(String tag) {
                View view2 = View.inflate(Main2Activity.this,R.layout.area,null);
                Button btn1 = (Button)view2.findViewById(R.id.button2);
                Button btn2 = (Button)view2.findViewById(R.id.button3);
                final EditText e2 = (EditText)view2.findViewById(R.id.editText3);
                final TextView t6 = (TextView)view2.findViewById(R.id.textView6);

                btn1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        float input = Float.parseFloat(e2.getText().toString());
                        double result = input * 3.305785;
                        t6.setText(result + " 제곱미터");
                    }
                });

                btn2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        float input = Float.parseFloat(e2.getText().toString());
                        double result = input / 3.305785;
                        t6.setText(result + " 평");
                    }
                });

                return view2;
            }
        }).setIndicator("면적 계산기");

        tab.addTab(tab2);


    }
}

