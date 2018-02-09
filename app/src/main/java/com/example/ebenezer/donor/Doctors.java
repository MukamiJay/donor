package com.example.ebenezer.donor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ebenezer.donor.models.Doctor;


public class Doctors extends AppCompatActivity {
    private EditText doc_contact,doc_description,doc_location,doc_name;
    private Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctors);
        setTitle("Doctor");

        init();
    }

    private void init(){
         doc_name = (EditText)findViewById(R.id.name);
         doc_contact = (EditText)findViewById(R.id.doc_contact);
         doc_description = (EditText)findViewById(R.id.doc_description);
         doc_location = (EditText)findViewById(R.id.doc_location);
         save = (Button)findViewById(R.id.save);

         save.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 save();
                 Log.e("here", "was here");
             }
         });
    }

    private void save() {

        String name =doc_name.getText().toString();
        String contact = doc_contact.getText().toString();
        String description = doc_description.getText().toString();
        String location = doc_location.getText().toString();

        if (name.isEmpty() || contact.isEmpty()||description.isEmpty() ||location.isEmpty()){
            Toast.makeText(getApplicationContext(),"Fill all...",Toast.LENGTH_SHORT).show();

        } else
            {
                Doctor doctor= new Doctor(
                        name,
                        contact,
                        description,
                        location
                );
                doctor.save();

                Intent intent = new Intent(getApplicationContext(),Home.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(),"Successfull ",Toast.LENGTH_SHORT).show();
            }

        }
    }

