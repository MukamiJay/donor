package com.example.ebenezer.donor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import com.example.ebenezer.donor.adapters.UsersAdapter;


import java.util.ArrayList;
import java.util.List;

public class AllUser extends AppCompatActivity {

    private List<com.example.ebenezer.donor.models.User> users = new ArrayList<>();
    private UsersAdapter usersAdapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_users);
        setTitle("Users");

        recyclerView = (RecyclerView) findViewById(R.id.user_recycler);
        users = com.example.ebenezer.donor.models.User.listAll(com.example.ebenezer.donor.models.User.class);

        Log.e("Count", String.valueOf(users.size()));
        usersAdapter= new UsersAdapter(users);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(usersAdapter);

    }
}
