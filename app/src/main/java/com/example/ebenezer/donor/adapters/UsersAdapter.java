package com.example.ebenezer.donor.adapters;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ebenezer.donor.R;
import com.example.ebenezer.donor.models.User;

import java.util.List;

/**
 * Created by EBENEZER on 2/5/2018.
 */

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.myViewHolder> {
    public List<User> usersList;

    public class myViewHolder extends RecyclerView.ViewHolder {
        public TextView username, password;

        public myViewHolder(View view) {
            super(view);
            username = (TextView) view.findViewById(R.id.username);
            password = (TextView) view.findViewById(R.id.password);
            }
    }


    public UsersAdapter(List<User> usersList) {
        this.usersList = usersList;
    }

    @Override
    public UsersAdapter.myViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_user_card, parent, false);

        return new UsersAdapter.myViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(myViewHolder holder, int position) {
        User user = usersList.get(position);
        holder.username.setText(user.getUsername());
        holder.password.setText(user.getPassword());

    }

    @Override
    public int getItemCount() {
        Log.e("elm", String.valueOf(usersList.size()));
        return usersList.size();

    }

}

