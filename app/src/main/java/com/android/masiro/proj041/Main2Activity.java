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

                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String temp = e11.getText().toString();
                        float height = Float.parseFloat(temp);
                        temp = e12.getText().toString();
                        float weight = Float.parseFloat(temp)/100;
                        float bmi = weight / (height * height);

                        if (bmi < 18.5) {
                            t4.setText("체중부족입니다");
                        } else if (bmi >= 18.5 && bmi < 23) {
                            t4.setText("정상체중입니다");
                        } else if (bmi >= 23 && bmi < 25) {
                            t4.setText("과체중입니다");
                        } else {
                            t4.setText("이상입니다");
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
                        t6.setText(result + "미터제곱");
                    }
                });

                btn2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        float input = Float.parseFloat(e2.getText().toString());
                        double result = input / 3.305785;
                        t6.setText(result + "평");
                    }
                });

                return view2;
            }
        }).setIndicator("면적 계산기");

        tab.addTab(tab2);


    }


public void OnButton(View v){
    switch(v.getId()){

        case R.id.button1:

            break;
        case R.id.button2:
            break;
        case R.id.button3:
            break;
    }

}


}

