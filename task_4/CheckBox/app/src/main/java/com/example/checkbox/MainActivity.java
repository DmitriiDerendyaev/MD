package com.example.checkbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private CheckBox checkBoxJuliet;
    private CheckBox checkBoxRomeo;
    private ToggleButton toggleButton;
    private RadioGroup radioGroupCharacters;
    private RadioButton radioRomeo;
    private RadioButton radioJuliet;
    private ImageButton imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkBoxJuliet = findViewById(R.id.checkbox_juliet);
        checkBoxRomeo = findViewById(R.id.checkbox_romeo);
        toggleButton = findViewById(R.id.toggle_button);
        radioGroupCharacters = findViewById(R.id.radio_group_characters);
        radioRomeo = findViewById(R.id.radio_romeo);
        radioJuliet = findViewById(R.id.radio_juliet);
        imageButton = findViewById(R.id.image_button);

        checkBoxJuliet.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    System.out.println("Джульетта говорит");
                    showToast("Джульетта говорит");
                } else {
                    System.out.println("Джульетта молчит");
                    showToast("Джульетта молчит");
                }
            }
        });

        checkBoxRomeo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    System.out.println("Ромео говорит");
                    showToast("Ромео говорит");
                } else {
                    System.out.println("Ромео молчит");
                    showToast("Ромео молчит");
                }
            }
        });

        toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isEnabled = !toggleButton.isChecked();
                checkBoxJuliet.setEnabled(isEnabled);
                checkBoxRomeo.setEnabled(isEnabled);
                radioRomeo.setEnabled(isEnabled);
                radioJuliet.setEnabled(isEnabled);

                if (isEnabled) {
                    showToast("Обработка включена");
                } else {
                    showToast("Обработка выключена");
                }
            }
        });

        radioGroupCharacters.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.radio_romeo) {
                    showToast("Выбран Ромео");
                    imageButton.setImageResource(R.drawable.romeo);
                } else if (checkedId == R.id.radio_juliet) {
                    showToast("Выбрана Джульетта");
                    imageButton.setImageResource(R.drawable.juliette);
                }
            }
        });

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("ImageButton нажата");
            }
        });
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}