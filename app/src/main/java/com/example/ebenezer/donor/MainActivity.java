package com.example.ebenezer.donor;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ebenezer.donor.models.User;
import com.orm.query.Condition;
import com.orm.query.Select;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MainActivity";
    private EditText user_name, pass_word;
    private TextView register;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

    }

    private void init(){
        user_name = (EditText) findViewById(R.id.user_name);
        pass_word = (EditText) findViewById(R.id.password);
        register = (TextView) findViewById(R.id.register);
        login = (Button) findViewById(R.id.login);
        //password.

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getApplicationContext(),"Login clicked",Toast.LENGTH_SHORT).show();
                login();
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
  //              Toast.makeText(getApplicationContext(),"Create",Toast.LENGTH_SHORT).show();
                Intent intent= new Intent(getApplicationContext(), Register.class);
                startActivity(intent);
            }
        });
    }

    public void login(){
        Log.e(TAG, "login called");
        String username= user_name.getText().toString();
        String password= pass_word.getText().toString();

        if (username.isEmpty() || password.isEmpty()){
            Toast.makeText(getApplicationContext(),"No data provided",Toast.LENGTH_SHORT).show();

        } else {
            int count = (int) Select.from(User.class)
                    .where(Condition.prop("username").eq(username))
                    .where(Condition.prop("password").eq(password))
                    .count();

            if (count > 0){
                SharedPreferences.Editor editor = getSharedPreferences("myprefs", MODE_PRIVATE).edit();
                editor.putString("username",username);
                editor.putString("password",password);
                editor.apply();

                Intent intent= new Intent(getApplicationContext(),Home.class);
                startActivity(intent);
            }else
            {
                Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_SHORT).show();
            }

        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
