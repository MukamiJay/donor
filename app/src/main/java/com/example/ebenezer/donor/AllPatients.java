package com.example.ebenezer.donor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.ebenezer.donor.R;
import com.example.ebenezer.donor.adapters.PatientAdapter;
import com.example.ebenezer.donor.models.*;

import java.util.ArrayList;
import java.util.List;

public class AllPatients extends AppCompatActivity {

    private List<com.example.ebenezer.donor.models.Patient> patients = new ArrayList<>();
    private PatientAdapter patientAdapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_patients);

        recyclerView = (RecyclerView) findViewById(R.id.patient_recycler);
        patients = com.example.ebenezer.donor.models.Patient.listAll(com.example.ebenezer.donor.models.Patient.class);

        Log.e("Count", String.valueOf(patients.size()));
        patientAdapter = new PatientAdapter(patients);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(patientAdapter);

    }
}
