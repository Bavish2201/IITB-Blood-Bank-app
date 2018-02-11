package com.hackathon.bloodbank.iitbbloodbank;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class DonorDetails extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donor_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final EditText name_edittext = findViewById(R.id.name_edittext);
        final EditText room_edittext = findViewById(R.id.room_edittext);
        final EditText contact_edittext = findViewById(R.id.contact_edittext);
        final CheckBox agreement_check = findViewById(R.id.agreement_checkBox);



        Button submitButton = (Button) findViewById(R.id.submit_button);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = name_edittext.getText().toString();
                String room = room_edittext.getText().toString();
                String contact = contact_edittext.getText().toString();

               if( !name.isEmpty() && !room.isEmpty() && !contact.isEmpty() && agreement_check.isChecked()) {
                   if(contact.length()==10) {
                       Toast.makeText(DonorDetails.this, "Successful!", Toast.LENGTH_SHORT).show();
                   }
                   else {
                       Toast.makeText(DonorDetails.this, "Enter a valid contact number", Toast.LENGTH_SHORT).show();
                   }

               }
               else {
                   Toast.makeText(DonorDetails.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
               }


        }});

        //
        // This is to show the Blood Group Drop Down List
        //
        Spinner blood_spinner = (Spinner) findViewById(R.id.bloodgroup_spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.blood_groups, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        blood_spinner.setAdapter(adapter);

        //
        // This is to show the Hostel Drop Down List
        //
        Spinner hostel_spinner = (Spinner) findViewById(R.id.hostel_spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,
                R.array.hostels, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        hostel_spinner.setAdapter(adapter1);


    }


    //
    // Function to handle gender radio buttons
    //
    //
    public String onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        String gender = "Male";

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.male_radioButton:
                if (checked)
                    gender = "Male";
                    break;
            case R.id.female_radioButton:
                if (checked)
                    gender = "Female";
                    break;
            case R.id.other_radioButton:
                if (checked)
                    gender = "Other";
                    break;
        }
        //Toast.makeText(this, "Success!", Toast.LENGTH_SHORT).show();
        return gender;
    }

}
