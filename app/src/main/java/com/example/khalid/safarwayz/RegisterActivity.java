package com.example.khalid.safarwayz;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    private DbHelper db;
    EditText et_name, et_contact, et_newusername, et_newpassword;
    Button btn_register;
    Context ctx = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        db = new DbHelper(this);
        et_name = (EditText)findViewById(R.id.et_name);
        et_contact = (EditText)findViewById(R.id.et_contact);
        et_newusername = (EditText)findViewById(R.id.et_newusername);
        et_newpassword = (EditText)findViewById(R.id.et_newpassword);
        btn_register = (Button)findViewById(R.id.btn_register);
    }

    public void registered(View view) {
        String name = et_name.getText().toString();
        String contact = et_contact.getText().toString();
        String newusername = et_newusername.getText().toString();
        String newpassword = et_newpassword.getText().toString();

        if(name.isEmpty() && contact.isEmpty() && newusername.isEmpty() && newpassword.isEmpty()){
            displayToast("Fields can't be empty!");
        } else {
            db.addUser(name,contact,newusername,newpassword);
            displayToast("User Registered...");
            finish();
        }
    }

    private void displayToast(String message){
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}