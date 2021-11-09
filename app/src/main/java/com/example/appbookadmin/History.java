package com.example.appbookadmin;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

import futsalrequest.Order;

public class History {

    private DatabaseReference databaseReference;

    public History(){
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        databaseReference = db.getReference(Order.class.getSimpleName());
    }
    public Task<Void> add (Order history){
        return databaseReference.push().setValue(history);
    }
    public Task<Void> update(String key, HashMap<String, Object> hashMap){

        return databaseReference.child(key).updateChildren(hashMap);
    }
}
