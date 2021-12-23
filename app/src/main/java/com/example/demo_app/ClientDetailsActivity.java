package com.example.demo_app;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import androidx.annotation.Nullable;

import androidx.annotation.NonNull;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;


import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ClientDetailsActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    DatabaseReference reference;
    FirebaseDatabase database;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        database = FirebaseDatabase.getInstance();

        reference = database.getReference("Details");
    }
    @Override
    protected void onStart(){
        super.onStart();

        FirebaseRecyclerOptions<ClientDetails> firebaseRecyclerOptions = new FirebaseRecyclerOptions.Builder<ClientDetails>().setQuery(reference,ClientDetails.class).build();
        FirebaseRecyclerAdapter<ClientDetails, ClientDetailsHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<ClientDetails, ClientDetailsHolder>(firebaseRecyclerOptions) {
            @Override
            protected void onBindViewHolder(@NonNull ClientDetailsHolder holder, int position, @NonNull ClientDetails model) {
                holder.setView(getApplication(),model.getClient(),model.getMtApayer());
            }

            @NonNull
            @Override
            public ClientDetailsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.details_data_activity,parent,false);
                return new ClientDetailsHolder(view);
            }

        };
        firebaseRecyclerAdapter.startListening();
        recyclerView.setAdapter(firebaseRecyclerAdapter);
    }
}
