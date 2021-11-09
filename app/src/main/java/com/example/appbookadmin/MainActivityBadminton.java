package com.example.appbookadmin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.WindowManager;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import futsalrequest.AdapterOrder;
import futsalrequest.Order;

public class MainActivityBadminton extends AppCompatActivity {

    RecyclerView BadmintonList;
    DatabaseReference databaseReference;
    AdapterOrder adapterOrder;
    ArrayList<Order> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_badminton);
        BadmintonList = findViewById(R.id.DataBadminton);
        databaseReference = FirebaseDatabase.getInstance().getReference("OrderBadminton");
        BadmintonList.setHasFixedSize(true);
        BadmintonList.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();
        adapterOrder = new AdapterOrder(this, list);
        BadmintonList.setAdapter(adapterOrder);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    Order order = dataSnapshot.getValue(Order.class);
                    list.add(order);

                }
                adapterOrder.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {

            }
        });
    }
}