package com.example.appbookadmin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;

import BuktiTransfer.ImageActivity;
import futsalrequest.MainActivity;

public class MenuAdmin extends AppCompatActivity {

    Button BtnFutsal, BtnBadminton, BtnBukti;
    private Uri mImageUri;
    private StorageReference mStorageRef;
    private DatabaseReference mDatabaseRef;
    private StorageTask mUploadTask;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.menu_admin);

        BtnFutsal = findViewById(R.id.buttonfutsal);
        BtnBadminton = findViewById(R.id.buttonbadminton);
        BtnBukti=findViewById(R.id.Transfer);

        mStorageRef = FirebaseStorage.getInstance().getReference("Images");
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("Images");


        BtnFutsal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuAdmin.this, MainActivity.class);
                startActivity(intent);
            }
        });
        BtnBadminton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuAdmin.this, MainActivityBadminton.class);
                startActivity(intent);
            }
        });
        BtnBukti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openImageActivity();
            }
        });

        }

    private void openImageActivity() {
        Intent intent = new Intent(this, ImageActivity.class);
        startActivity(intent);
    }
}