package com.example.mydialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.fragment.app.DialogFragment;

public class MyDialogFragment extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new
                AlertDialog.Builder(getActivity());
        builder.setMessage("Диалоговое окно отображения текста");
                LayoutInflater inflater =
                        requireActivity().getLayoutInflater();
        View layout = inflater.inflate(R.layout.dialog_layout,null);
        builder.setView(layout);
        final EditText myText = layout.findViewById(R.id.editTextText);
        builder.setPositiveButton("Завершить", (dialog, id) -> {
            requireActivity().finish();
        });
        builder.setNegativeButton("Назад", (dialog, id) -> dialog.cancel());
        builder.setNeutralButton("Отобразить текст", (dialog, id) -> {
            MyDialogFragmentListener activity = (MyDialogFragmentListener)
                    getActivity();
            assert activity != null;
            activity.onReturnValue(String.valueOf(myText.getText()));
        });
        return builder.create();
    }
    public interface MyDialogFragmentListener {
        void onReturnValue(String value);
    }
}