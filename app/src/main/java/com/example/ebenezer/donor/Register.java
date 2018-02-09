package com.example.ebenezer.donor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ebenezer.donor.models.User;

public class Register extends AppCompatActivity {

    private EditText email, username, password, confirmpassword;
    private Button signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        setTitle("Register");
        init();
    }

    private void init() {
        email = (EditText) findViewById(R.id.email_address);
        username = (EditText) findViewById(R.id.Username);
        password = (EditText) findViewById(R.id.password);
        confirmpassword = (EditText) findViewById(R.id.confirm_password);
        signup = (Button) findViewById(R.id.signup);

        //Data entered
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signup();
            }
        });
    }

    public void signup() {


        String user_name = username.getText().toString();
        String pass_word = password.getText().toString();
        String confirm_password = String.valueOf(confirmpassword.getText());
        String email_add = email.getText().toString();

        Log.e("Password", pass_word+"   "+confirm_password);
        if ( user_name.isEmpty() || pass_word.isEmpty() || email_add.isEmpty() || confirm_password.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Fill all", Toast.LENGTH_SHORT).show();
        } else {
            if (pass_word.equals(confirm_password)) {
                Toast.makeText(getApplicationContext(), "Created", Toast.LENGTH_SHORT).show();
                User user= new User(
                        user_name,
                        email_add,
                        pass_word
                );
                user.save();

                Intent intent = new Intent(getApplicationContext(),Home.class);
                startActivity(intent);
            } else {
                Toast.makeText(getApplicationContext(), "password does not match", Toast.LENGTH_SHORT).show();
            }
        }

    }


}
