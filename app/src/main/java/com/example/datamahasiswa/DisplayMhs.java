package com.example.datamahasiswa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DisplayMhs extends AppCompatActivity {
    int from_Where_I_Am_Coming = 0;
    int id_To_Update;
    private DBHelper mydb;

    TextView noMhs, nama, phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_mhs);
        noMhs = (TextView) findViewById(R.id.etNIM);
        nama  = (TextView) findViewById(R.id.etName);
        phone = (TextView) findViewById(R.id.etPhone);
    }
}
