package com.example.listenerresearch;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText num1EditText;
    private EditText num2EditText;
    private EditText resultEditText;
    private Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1EditText = findViewById(R.id.editTextNum1);
        num2EditText = findViewById(R.id.editTextNum2);
        resultEditText = findViewById(R.id.editTextResult);
        addButton = findViewById(R.id.buttonAdd);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateSum();
            }
        });
    }

    private void calculateSum() {
        // Получаем значения из полей ввода
        String num1Str = num1EditText.getText().toString();
        String num2Str = num2EditText.getText().toString();

        // Проверяем, что поля не пустые
        if (num1Str.isEmpty() || num2Str.isEmpty()) {
            resultEditText.setText("Введите оба числа");
            return;
        }

        // Преобразуем строки в числа
        double num1 = Double.parseDouble(num1Str);
        double num2 = Double.parseDouble(num2Str);

        // Выполняем операцию сложения
        double sum = num1 + num2;

        // Выводим результат на экран
        resultEditText.setText(String.valueOf(sum));
    }
}
