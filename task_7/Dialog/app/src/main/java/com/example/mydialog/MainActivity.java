package com.example.mydialog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements
        MyDialogFragment.MyDialogFragmentListener {
    private TextView myText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button myButton = findViewById(R.id.button);
        myText = findViewById(R.id.textView);
        myButton.setOnClickListener(v -> {
            FragmentManager manager = getSupportFragmentManager();
            MyDialogFragment myDialogFragment = new
                    MyDialogFragment();
            myDialogFragment.show(manager, "myDialog");
        });
    }
    @Override
    public void onReturnValue(String value) {
        myText.setText("Ваш текст: " + value);
    }
}