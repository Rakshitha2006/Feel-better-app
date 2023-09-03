package com.example.feelbetterapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
public class registerpage extends AppCompatActivity {


    EditText username, password, retypepassword ;
    Button signup;
    TextView signin;
    DBuser DB;

    TextView frm;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registerpage);

        username =(EditText) findViewById(R.id.username);
        password =(EditText) findViewById(R.id.password);
        retypepassword =(EditText) findViewById(R.id.repassword);
        signup =(Button) findViewById(R.id.btnsingup);
        signin =(TextView) findViewById(R.id.existinguser);
        frm= (TextView) findViewById(R.id.form);
        DB = new DBuser(this);



        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String repass = retypepassword.getText().toString();

                if (user.equals("") || pass.equals("") ||repass.equals(""))
                    Toast.makeText(registerpage.this, "Please enter all the fields!!", Toast.LENGTH_SHORT).show();
                else {
                    if (pass.equals(repass)) {
                        Boolean checkuser = DB.checkusername(user);
                        if (checkuser == false) {
                            Boolean insert = DB.inserData(user, pass);
                            if (insert == true) {
                                Toast.makeText(registerpage.this, "Registered Successfully!!", Toast.LENGTH_SHORT).show();
                            }else{
                                Toast.makeText(registerpage.this, "Registeration failed..", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(registerpage.this, "User already exists!! Please sign in", Toast.LENGTH_SHORT).show();
                        }

                    }
                    else{
                        Toast.makeText(registerpage.this, "Password not match!!", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });



        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent =new Intent(getApplicationContext(),loginactivity.class);
                startActivity(intent);

            }
        });

        frm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getApplicationContext(),form.class);
                startActivity(intent);
            }
        });


    }
}


