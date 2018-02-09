package com.example.ebenezer.donor;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ebenezer.donor.models.Doctor;
import com.google.android.gms.maps.MapFragment;

public class Donor extends AppCompatActivity {

    private EditText don_contact,don_blood_group,don_location,don_name;
    private Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donor);
        setTitle("Donor");

        init();
    }

    private void init(){
       don_name = (EditText)findViewById(R.id.don_name);
        don_contact = (EditText)findViewById(R.id.don_contact);
        don_blood_group = (EditText)findViewById(R.id.don_blood_group);
        don_location = (EditText)findViewById(R.id.don_location);
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

        String name = don_name.getText().toString();
        String contact = don_contact.getText().toString();
        String blood_group = don_blood_group.getText().toString();
        String location = don_location.getText().toString();

        if (name.isEmpty() || contact.isEmpty() || blood_group.isEmpty() || location.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Fill all...", Toast.LENGTH_SHORT).show();

        } else {
            com.example.ebenezer.donor.models.Donors donors = new com.example.ebenezer.donor.models.Donors(
                    name,
                    blood_group,
                    location,
                    contact
            );

            donors.save();

            Intent intent = new Intent(getApplicationContext(), Donor.class);
            startActivity(intent);
            Toast.makeText(getApplicationContext(), "Successfull ", Toast.LENGTH_SHORT).show();
            Log.e("haha", "haha");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_donor, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.vieww_all){
            Log.e("donor","success");
            Intent intent = new Intent(getApplicationContext(),Alldonors.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }



}

