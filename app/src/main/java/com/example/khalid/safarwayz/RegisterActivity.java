package com.example.khalid.safarwayz;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    EditText et_name, et_contact, et_newusername, et_newpassword;
    Button btn_register;
    Context ctx = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        et_name = (EditText)findViewById(R.id.et_name);
        et_contact = (EditText)findViewById(R.id.et_contact);
        et_newusername = (EditText)findViewById(R.id.et_newusername);
        et_newpassword = (EditText)findViewById(R.id.et_newpassword);
        btn_register = (Button)findViewById(R.id.btn_register);
    }

    public void registered(View view)
    {
        String name = et_name.getText().toString();
        String contact = et_contact.getText().toString();
        String newusername = et_newusername.getText().toString();
        String newpassword = et_newpassword.getText().toString();

        DatabaseOperation dop = new DatabaseOperation(ctx);
        dop.putInformation(dop, name, Integer.parseInt(contact), newusername, newpassword);
        Toast.makeText(getBaseContext(), "REGISTRATION SUCCESS",Toast.LENGTH_LONG).show();
        finish();

        Intent intent = new Intent("com.example.khalid.safarwayz.SecondActivity");
        startActivity(intent);
    }
}
