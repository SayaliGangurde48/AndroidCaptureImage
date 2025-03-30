package com.example.androidcaptureimage;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        button = findViewById(R.id.button);

        //Request for camera runtime permission
        if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CAMERA)
        != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(MainActivity.this,new String[]{
                    Manifest.permission.CAMERA
            },100);


            }
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent   = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
               startActivityForResult(intent,100);

            }
        });


        }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==100){
            Bitmap bitmap = (Bitmap)  data.getExtras().get("data");
            imageView.setImageBitmap(bitmap);


    }
};
    }
