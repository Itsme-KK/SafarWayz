package com.example.khalid.safarwayz;

import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


public class SecondActivity extends AppCompatActivity {

    Button btn_info,btn_logout;
    RadioButton rbow, rbrw;
    EditText et_source, et_destination, et_departure_date, et_return_date;
    TextView textView3;
    private Session session;
    private static final String TAG = "SecondActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        RadioGroup groupRadio = (RadioGroup)findViewById(R.id.groupRadio);
        btn_info = (Button)findViewById(R.id.btn_info);
        btn_logout = (Button)findViewById(R.id.btn_logout);
        rbow = (RadioButton)findViewById(R.id.rbow);
        rbrw = (RadioButton)findViewById(R.id.rbrw);
        et_source = (EditText)findViewById(R.id.et_source);
        et_destination = (EditText)findViewById(R.id.et_destination);
        et_departure_date = (EditText)findViewById(R.id.et_departure_date);
        et_return_date = (EditText)findViewById(R.id.et_return_date);
        textView3 = (TextView)findViewById(R.id.textView3);

        Intent incomingIntent = getIntent();
        String date = incomingIntent.getStringExtra("date");
        et_departure_date.setText(date);

        groupRadio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                if(checkedId==R.id.rbow){
                    et_return_date.setVisibility(View.INVISIBLE);
                    textView3.setVisibility(View.INVISIBLE);
                } else if(checkedId==R.id.rbrw){
                    et_return_date.setVisibility(View.VISIBLE);
                    textView3.setVisibility(View.VISIBLE);
                }
            }
        });
        session = new Session(this);
        if(!session.loggedin()){
            logout();
        }
        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
            }
        });
    }

    public void calendar(View view) {
        Intent intent = new Intent("com.example.khalid.safarwayz.CalendarActivity");
        startActivity(intent);
    }

    public void search(View view) {}

    public void logout(){
        session.setLoggedin(false);
        finish();
        startActivity(new Intent(SecondActivity.this,MainActivity.class));
    }
}