package com.example.ebenezer.donor.adapters;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ebenezer.donor.R;
import com.example.ebenezer.donor.models.Patient;

import java.util.List;

/**
 * Created by EBENEZER on 2/5/2018.
 */

public class PatientAdapter extends RecyclerView.Adapter<PatientAdapter.myViewHolder> {

    public List<Patient> patientList;

    public class myViewHolder extends RecyclerView.ViewHolder {
        public TextView name, location, contact, group;

        public myViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.card_name);
            location = (TextView) view.findViewById(R.id.card_location);
            contact = (TextView) view.findViewById(R.id.card_contact);
            group = (TextView) view.findViewById(R.id.card_blood);
        }
    }


    public PatientAdapter(List<Patient> patientList) {
        this.patientList = patientList;
    }

    @Override
    public myViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.patient_card, parent, false);

        return new myViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(myViewHolder holder, int position) {
        Patient patient = patientList.get(position);
        holder.name.setText(patient.getPatient_name());
        holder.contact.setText(patient.getContact());
        holder.location.setText(patient.getLocation());
        holder.group.setText(patient.getBlood_group());

    }

    @Override
    public int getItemCount() {
        Log.e("elm", String.valueOf(patientList.size()));
        return patientList.size();

    }

}
