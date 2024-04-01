package com.example.demoaplikasi;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements TextWatcher {
    AutoCompleteTextView ac;
    EditText lv;
    public String[] stringdatafak = {"Fakultas Ekonomi", "Fakultas Kehutanan", "Fakultas Ilmu Komputer", "Fakultas Hukum", "Fakultas Keguruan dan Ilmu Pendidikan"};
    private String lifeCycle = "androidlifecycle";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ac = findViewById(R.id.dataautocomplete);
        lv = findViewById(R.id.datalistview);

        ac.addTextChangedListener(this);
        ac.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, stringdatafak));
    }

    public void pilihfakultas(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Data Fakultas Universitas Kuningan");
        builder.setItems(stringdatafak, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {
                lv.setText(stringdatafak[item]);
                dialog.dismiss();
            }
        }).show();
    }

    public void onTextChanged(CharSequence s, int start, int before, int count) {
    }

    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    public void afterTextChanged(Editable s) {
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "Posisi lagi start nih", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "Posisi lagi stop nih", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "Posisi lagi Resume nih", Toast.LENGTH_LONG).show();
        TextView txt1 = findViewById(R.id.txt1);
        txt1.setText("POSISI LAGI RESUME");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "Posisi lagi pause nih", Toast.LENGTH_LONG).show();
        LinearLayout linearLayout = findViewById(R.id.linearParent);
        linearLayout.setBackgroundColor(getResources().getColor(R.color.purple_200));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Posisi udah hancur nih", Toast.LENGTH_LONG).show();
    }
}
