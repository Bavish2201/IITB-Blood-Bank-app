package com.hackathon.bloodbank.iitbbloodbank;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button search_button = (Button) findViewById(R.id.search_main_button);
        search_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent donorDetailsIntent = new Intent(MainActivity.this, SearchActivity.class);
                startActivity(donorDetailsIntent);
            }
        });

        Button register_button = (Button) findViewById(R.id.register_button);
        register_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent donorDetailsIntent = new Intent(MainActivity.this, DonorDetails.class);
                startActivity(donorDetailsIntent);
            }
        });
    }
}
