package com.example.ebenezer.donor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class Patient extends AppCompatActivity {

    private EditText pat_contact,pat_blood_group,pat_location,pat_name;
    private Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient);
        setTitle("Patient");

        init();
    }

    private void init(){
        pat_name = (EditText)findViewById(R.id.pat_name);
        pat_contact = (EditText)findViewById(R.id.pat_contact);
        pat_blood_group = (EditText)findViewById(R.id.pat_blood_group);
        pat_location = (EditText)findViewById(R.id.pat_location);
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

        String name =pat_name.getText().toString();
        String contact = pat_contact.getText().toString();
        String blood_group= pat_blood_group.getText().toString();
        String location = pat_location.getText().toString();

        if (name.isEmpty() || contact.isEmpty()||blood_group.isEmpty() ||location.isEmpty()){
            Toast.makeText(getApplicationContext(),"Fill all...",Toast.LENGTH_SHORT).show();

        } else
        {
            com.example.ebenezer.donor.models.Patient patient = new com.example.ebenezer.donor.models.Patient(
                    name,
                    blood_group,
                    location,
                    contact
            );

            patient.save();

            Intent intent = new Intent(getApplicationContext(),AllPatients.class);
            startActivity(intent);
            Toast.makeText(getApplicationContext(),"Successfull ",Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_patient, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.view_all){
            Intent intent = new Intent(getApplicationContext(),AllPatients.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}