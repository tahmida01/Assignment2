package com.example.assignment2; // Change this to your package name

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.RadioGroup;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private CheckBox pasta, burger, biriyani;
    private RadioGroup radioGroup;
    private RatingBar ratingBar;
    private SeekBar seekBar;
    private Switch btnSwitch;
    private TextView idTVStatus, foodsStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Ensure your XML layout file is named correctly

        pasta = findViewById(R.id.pasta);
        burger = findViewById(R.id.burger);
        biriyani = findViewById(R.id.biriyani);
        radioGroup = findViewById(R.id.radioGroup);
        ratingBar = findViewById(R.id.ratingBar);
        seekBar = findViewById(R.id.seekBar);
        btnSwitch = findViewById(R.id.btn_switch);
        idTVStatus = findViewById(R.id.idTVStatus);
        foodsStatus = findViewById(R.id.foods);

        // Checkbox Listener
        pasta.setOnCheckedChangeListener((buttonView, isChecked) -> updateFoodSelection());
        burger.setOnCheckedChangeListener((buttonView, isChecked) -> updateFoodSelection());
        biriyani.setOnCheckedChangeListener((buttonView, isChecked) -> updateFoodSelection());

        // RadioGroup Listener
        radioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.radioButton1) {
                idTVStatus.setText("Selected: 1");
            } else if (checkedId == R.id.radioButton2) {
                idTVStatus.setText("Selected: 2");
            } else if (checkedId == R.id.radioButton3) {
                idTVStatus.setText("Selected: 3");
            } else if (checkedId == R.id.radioButton4) {
                idTVStatus.setText("Selected: 4");
            }
        });

        // RatingBar Listener
        ratingBar.setOnRatingBarChangeListener((ratingBar, rating, fromUser) -> {
            Toast.makeText(MainActivity.this, "Rating: " + rating, Toast.LENGTH_SHORT).show();
        });

        // SeekBar Listener
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                idTVStatus.setText("SeekBar Value: " + progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        // Switch Listener
        btnSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                Toast.makeText(MainActivity.this, "Switch is ON", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, "Switch is OFF", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void updateFoodSelection() {
        StringBuilder selectedFoods = new StringBuilder("Selected Foods: ");
        if (pasta.isChecked()) selectedFoods.append(pasta.getText()).append(", ");
        if (burger.isChecked()) selectedFoods.append(burger.getText()).append(", ");
        if (biriyani.isChecked()) selectedFoods.append(biriyani.getText()).append(", ");

        // Remove the last comma and space if there are any selected
        if (selectedFoods.length() > 16) { // Length of "Selected Foods: "
            selectedFoods.setLength(selectedFoods.length() - 2);
        } else {
            selectedFoods.append("None");
        }

        foodsStatus.setText(selectedFoods.toString());
    }
}
