package com.example.khalid.safarwayz;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et_username, et_password;
    Button btn_login;
    TextView tv_register;
    Context ctx = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_username = (EditText)findViewById(R.id.et_username);
        et_password = (EditText)findViewById(R.id.et_password);
        btn_login = (Button) findViewById(R.id.btn_login);
        tv_register = (TextView)findViewById(R.id.tv_register);
    }

    public void login(View view)
    {
        String username = et_username.getText().toString();
        String password = et_password.getText().toString();

        DatabaseOperation dop = new DatabaseOperation(ctx);
        Cursor cr = dop.getInformation(dop);
        cr.moveToFirst();
        Boolean login_status = false;
        String user_name;
        do
        {
            if(username.equals(cr.getString(0)) && (password.equals(cr.getString(1))))
            {
                login_status = true;
                user_name = cr.getString(0);
            }

        }while (cr.moveToNext());

        if(login_status)
        {
            Toast.makeText(getBaseContext(),"LOGIN SUCCESSFUL...",Toast.LENGTH_LONG).show();
            Intent intent = new Intent("com.example.khalid.safarwayz.SecondActivity");
            startActivity(intent);
        }
        else
        {
            Toast.makeText(getBaseContext(),"LOGIN FAILED...\nUSERNAME OR PASSWORD IS INCORRECT",Toast.LENGTH_LONG).show();
        }
    }

    public void register(View view)
    {
        Intent intent = new Intent("com.example.khalid.safarwayz.RegisterActivity");
        startActivity(intent);
    }
}
