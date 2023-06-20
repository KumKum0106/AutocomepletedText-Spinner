package com.example.autocompletetext;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    // create array of Strings and store name of courses
    String[] courses = {"C++", "JAVA", "PYTHON", "C#", "RUBY", "GO LANG", "INTERVIEW PREPARATION", "OS", "DSA"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Creating Variables for Autocompleted Text and Spinner
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView)findViewById(R.id.autocompleteTextView);
        Spinner spins = findViewById(R.id.courses);

        spins.setOnItemSelectedListener(this); // tells which item of spinner is clicked

        ArrayAdapter ad = new ArrayAdapter(this, android.R.layout.simple_spinner_item, courses); // Instance of ArrayAdapter

        ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // simple layout resource file for each item of Spinner

        spins.setAdapter(ad); //Set the ArrayAdapter (ad) data on the Spinner which binds data to spinner

        // Creating string array and store the values.
        String[] hobby = { "Playing Cricket", "Swimming", "Playing Music", "Football", "Badminton", "Sports", "Singing", "Dancing", "Drawing", "Zumba", "Cooking", "Athletics", "Anchoring", "Fishing"};

        // Creating the object of ArrayAdapter with String, hold the data as the list item.
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.select_dialog_item, hobby);

        // Give suggestion after 1 words.
        autoCompleteTextView.setThreshold(1);

        // Set the adapter for data as a list
        autoCompleteTextView.setAdapter(adapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
        Toast.makeText(getApplicationContext(), courses[position], Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}