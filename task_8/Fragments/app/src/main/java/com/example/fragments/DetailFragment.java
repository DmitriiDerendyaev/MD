package com.example.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class DetailFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup
            container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }
    public void setSelectedItem(String selectedItem) {
        TextView desc = getView().findViewById(R.id.detailsText);
        ImageView photo = getView().findViewById(R.id.photo);
        switch (selectedItem) {
            case "Java":
                desc.setText(R.string.Java);
                photo.setImageResource(R.drawable.java);
                break;
            case "Python":
                desc.setText(R.string.Python);
                photo.setImageResource(R.drawable.python);
                break;
            case "C++":
                desc.setText(R.string.C);
                photo.setImageResource(R.drawable.c);
                break;
        }
    }
}
