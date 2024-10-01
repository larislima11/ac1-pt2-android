package com.example.ac1_2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DetailsActivity extends AppCompatActivity {

    private String phoneNumber;
    private String websiteUrl;
    private String locationName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Intent intent = getIntent();
        String place = intent.getStringExtra("place");

        ImageView image1 = findViewById(R.id.image1);
        ImageView image2 = findViewById(R.id.image2);
        TextView description = findViewById(R.id.description);

        switch (place) {
            case "zoo":
                image1.setImageResource(R.mipmap.zoo1);
                image2.setImageResource(R.mipmap.zoo2);
                description.setText("O zoológico tem uma enorme variedade de animais e é um dos maiores do país.");
                phoneNumber = getString(R.string.zoo_phone);
                websiteUrl = getString(R.string.zoo_website);
                locationName = getString(R.string.zoo_loc);
                break;
            case "shopping":
                image1.setImageResource(R.mipmap.shopping1);
                image2.setImageResource(R.mipmap.shopping2);
                description.setText("O Iguatemi Esplanada possui grande variedade de lojas, cinemas e restaurantes.");
                phoneNumber = getString(R.string.shopping_phone);
                websiteUrl = getString(R.string.shopping_website);
                locationName = getString(R.string.shopping_loc);
                break;
            case "parque":
                image1.setImageResource(R.mipmap.parque1);
                image2.setImageResource(R.mipmap.parque2);
                description.setText("O Parque Natural Chico Mendes possui um grande lago, trilhas e muita biodiversidade.");
                phoneNumber = getString(R.string.parque_phone);
                websiteUrl = getString(R.string.parque_website);
                locationName = getString(R.string.parque_loc);
                break;
        }
    }

    public void gotoMain(View view) {
        finish();
    }

    public void showMap(View view) {
        Uri gmmIntentUri = Uri.parse("geo:0,0?q=" + locationName);
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
    }

    public void openWebsite(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(websiteUrl));
        startActivity(browserIntent);
    }

    public void makeCall(View view) {
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:" + phoneNumber));
        startActivity(callIntent);
    }
}