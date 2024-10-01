package com.example.ac1_2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showDetails(View view) {
        Intent intent = new Intent(this, DetailsActivity.class);
        intent.putExtra("place", view.getTag().toString());
        startActivity(intent);
    }
}