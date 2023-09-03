package com.example.feelbetterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.content.Intent;
import android.widget.Toast;

public class resetactivity extends AppCompatActivity {

    TextView username;
    EditText pass,repass;
    DBuser DB;
    Button confirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resetactivity);

        username = (TextView) findViewById(R.id.username_reset_text);
        pass = (EditText) findViewById(R.id.password_reset);
        repass=(EditText) findViewById(R.id.repassword_reset);
        confirm =(Button) findViewById(R.id.btnconfirm);
        DB=new DBuser(this);

        Intent intent =getIntent();
        username.setText(intent.getStringExtra("username"));
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user=username.getText().toString();
                String password =pass.getText().toString();
                String repassword=repass.getText().toString();
                if(password.equals(repassword)) {

                    Boolean checkpasswordupdate = DB.updatepassword(user, password);
                    if (checkpasswordupdate == true) {
                        Intent intent = new Intent(getApplicationContext(), loginactivity.class);
                        startActivity(intent);
                        Toast.makeText(resetactivity.this,"Password updated successfully",Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(resetactivity.this,"Password not updated",Toast.LENGTH_SHORT).show();
                    }
                }else
                {
                    Toast.makeText(resetactivity.this,"Password mismatch",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}

