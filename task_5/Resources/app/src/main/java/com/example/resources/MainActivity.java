package com.example.resources;

import android.content.res.Configuration;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

public class MainActivity extends AppCompatActivity {

    private LinearLayout myLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myLayout = findViewById(R.id.root);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            myLayout.setBackgroundResource(R.drawable.back_landscape);
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            myLayout.setBackgroundResource(R.drawable.back_portrait);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        final LinearLayout myLayout = findViewById(R.id.root);
        int viewId = item.getItemId();

        if (viewId == R.id.red) {
            myLayout.setBackgroundColor(getResources().getColor(R.color.red));
            return true;
        } else if (viewId == R.id.green) {
            myLayout.setBackgroundColor(getResources().getColor(R.color.green));
            return true;
        } else if (viewId == R.id.blue) {
            myLayout.setBackgroundColor(getResources().getColor(R.color.blue));
            return true;
        } else if (viewId == R.id.exit) {
            finish();
            return true;
        } else if (viewId == R.id.add_text_field) {
            EditText editText = new EditText(this);
            myLayout.addView(editText, new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
            ));
            return true;
        } else if (viewId == R.id.add_image) {
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(R.drawable.cat);
            myLayout.addView(imageView, new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
            ));
            return true;
        } else if (viewId == R.id.change_font) {
            Typeface newTypeface = ResourcesCompat.getFont(this, R.font.fonts);
            setFontForViewGroup(myLayout, newTypeface);
            return true;
        }
        else {
            return super.onOptionsItemSelected(item);
        }
    }

    private void setFontForViewGroup(ViewGroup viewGroup, Typeface typeface) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View child = viewGroup.getChildAt(i);
            if (child instanceof TextView) {
                ((TextView) child).setTypeface(typeface);
            } else if (child instanceof ViewGroup) {
                setFontForViewGroup((ViewGroup) child, typeface);
            }
        }
    }
}
