package com.example.texteditor;


import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity implements
        View.OnClickListener {
    private float mTextSize = 20;
    private EditText mEdit;
    private TextView tSize;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEdit = findViewById(R.id.edit_text);
        tSize = findViewById(R.id.textSizeValue);
        Button buttonB = findViewById(R.id.button_b);
        Button buttonI = findViewById(R.id.button_i);
        Button buttonSans = findViewById(R.id.button_sans);
// ***
        Button buttonSerif = findViewById(R.id.button_serif);
        Button buttonMonospace = findViewById(R.id.button_monospace);

        Button buttonPlus = findViewById(R.id.button_plus);
        Button buttonMinus = findViewById(R.id.button_minus);

        buttonB.setOnClickListener(this);
        buttonI.setOnClickListener(this);
        buttonSans.setOnClickListener(this);
        buttonSerif.setOnClickListener(this);
        buttonMonospace.setOnClickListener(this);

        buttonPlus.setOnClickListener(this);
        buttonMinus.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {
        int viewId = v.getId();
        if (viewId == R.id.button_plus) {
            if (mTextSize < 72) {
                mTextSize += 2;
                mEdit.setTextSize(mTextSize);
                tSize.setText(String.format("%.0f", mTextSize));
            }
        } else if (viewId == R.id.button_minus) {
            if (mTextSize > 18) {
                mTextSize -= 2;
                mEdit.setTextSize(mTextSize);
                tSize.setText(String.format("%.0f", mTextSize));
            }
        } else if (viewId == R.id.button_b) {
            if (mEdit.getTypeface().getStyle() == Typeface.ITALIC)
                mEdit.setTypeface(mEdit.getTypeface(), Typeface.BOLD_ITALIC);
            else if (mEdit.getTypeface().getStyle() == Typeface.BOLD_ITALIC)
                mEdit.setTypeface(mEdit.getTypeface(), Typeface.ITALIC);
            else if (mEdit.getTypeface().getStyle() == Typeface.BOLD)
                mEdit.setTypeface(Typeface.create(mEdit.getTypeface(), Typeface.NORMAL));
            else mEdit.setTypeface(mEdit.getTypeface(), Typeface.BOLD);
        } else if (viewId == R.id.button_i) {
            if (mEdit.getTypeface().getStyle() == Typeface.BOLD)
                mEdit.setTypeface(mEdit.getTypeface(), Typeface.BOLD_ITALIC);
            else if (mEdit.getTypeface().getStyle() == Typeface.BOLD_ITALIC)
                mEdit.setTypeface(mEdit.getTypeface(), Typeface.BOLD);
            else if (mEdit.getTypeface().getStyle() == Typeface.ITALIC)
                mEdit.setTypeface(mEdit.getTypeface(), Typeface.NORMAL);
            else mEdit.setTypeface(mEdit.getTypeface(), Typeface.ITALIC);
        } else if (viewId == R.id.button_sans) {
            mEdit.setTypeface(Typeface.SANS_SERIF);
        } else if (viewId == R.id.button_serif) {
            mEdit.setTypeface(Typeface.SERIF);
        } else if (viewId == R.id.button_monospace) {
            mEdit.setTypeface(Typeface.MONOSPACE);
        }
    }
}