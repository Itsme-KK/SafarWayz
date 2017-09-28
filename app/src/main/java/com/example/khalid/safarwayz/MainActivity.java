package com.example.khalid.safarwayz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private DbHelper db;
    private Session session;
    EditText et_username, et_password;
    Button btn_login;
    TextView tv_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DbHelper(this);
        session = new Session(this);
        et_username = (EditText)findViewById(R.id.et_username);
        et_password = (EditText)findViewById(R.id.et_password);
        btn_login = (Button) findViewById(R.id.btn_login);
        tv_register = (TextView)findViewById(R.id.tv_register);

        if(session.loggedin()){
            Intent intent = new Intent("com.example.khalid.safarwayz.SecondActivity");
            startActivity(intent);
            finish();
        }
    }

    public void login(View view)
    {
        String username = et_username.getText().toString();
        String password = et_password.getText().toString();

        if(db.getUser(username,password)) {
            session.setLoggedin(true);
            Intent intent = new Intent("com.example.khalid.safarwayz.SecondActivity");
            startActivity(intent);
        } else {
            Toast.makeText(getApplicationContext(),"Username or Password is invalid!",Toast.LENGTH_LONG).show();
        }
    }

    public void register(View view)
    {
        Intent intent = new Intent("com.example.khalid.safarwayz.RegisterActivity");
        startActivity(intent);
    }
}