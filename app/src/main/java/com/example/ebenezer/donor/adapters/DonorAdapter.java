package com.example.ebenezer.donor.adapters;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ebenezer.donor.Donor;
import com.example.ebenezer.donor.R;
import com.example.ebenezer.donor.models.Donors;

import java.util.List;

public class DonorAdapter extends RecyclerView.Adapter<DonorAdapter.myViewHolder> {

    public List<Donors> donorList;

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


    public DonorAdapter(List<Donors> donorList) {
        this.donorList = donorList;
    }

    @Override
    public myViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_donor_card, parent, false);

        return new myViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(myViewHolder holder, int position) {
        Donors donor = donorList.get(position);
        holder.name.setText(donor.getName());
        holder.contact.setText(donor.getContact());
        holder.location.setText(donor.getLocation());
        holder.group.setText(donor.getBloodgroup());

    }

    @Override
    public int getItemCount() {
        Log.e("elm", String.valueOf(donorList.size()));
        return donorList.size();

    }

}

