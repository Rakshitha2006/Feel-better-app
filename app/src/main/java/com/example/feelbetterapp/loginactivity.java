package com.example.feelbetterapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.TextView;

public class loginactivity extends AppCompatActivity {

    EditText username,password;
    TextView forgot;
    Button btnsigin;
    DBuser DB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginactivity);


        username = (EditText) findViewById(R.id.username1);
        password =(EditText) findViewById(R.id.password1);
        btnsigin = (Button)  findViewById(R.id.btnsingin);
        forgot=(TextView) findViewById(R.id.forgot);
        DB = new DBuser(this);

        btnsigin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();


                if (user.equals("") || pass.equals(""))
                    Toast.makeText(loginactivity.this, "Please enter all the fields!!", Toast.LENGTH_SHORT).show();
                else {
                    Boolean checkuserpass = DB.checkusernamepassword(user, pass);
                    if (checkuserpass) {
                        Toast.makeText(loginactivity.this, "sign in successfull", Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(loginactivity.this, "invalid Credentials", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });
        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent =new Intent(getApplicationContext(), passwordactivity.class);
                startActivity(intent);
            }
        });
        btnsigin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent =new Intent(getApplicationContext(),dashboard.class);
                startActivity(intent);
            }
        });


    }
}
