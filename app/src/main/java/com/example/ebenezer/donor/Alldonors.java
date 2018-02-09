package com.example.ebenezer.donor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.ebenezer.donor.adapters.DonorAdapter;
import com.example.ebenezer.donor.adapters.PatientAdapter;
import com.example.ebenezer.donor.models.*;

import java.util.ArrayList;
import java.util.List;

public class Alldonors extends AppCompatActivity {

        private List<Donors> donors = new ArrayList<>();
        private DonorAdapter donorAdapter;
        RecyclerView recyclerView;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_all_donors);

            recyclerView = (RecyclerView) findViewById(R.id.donor_recycler);
            donors = com.example.ebenezer.donor.models.Donors.listAll(com.example.ebenezer.donor.models.Donors.class);

            Log.e("Count", String.valueOf(donors.size()));
            donorAdapter = new DonorAdapter(donors);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(donorAdapter);

        }
    }