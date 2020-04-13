package com.example.datamahasiswa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class DisplayMhs extends AppCompatActivity {
    int from_Where_I_Am_Coming = 0;
    int id_To_Update = 0;
    private DBHelper mydb;

    EditText noMhs, nama, noPhone;
    String nim, name, phone;
    Button btnSimpan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_mhs);
        noMhs   = (EditText) findViewById(R.id.etNIM);
        nama    = (EditText) findViewById(R.id.etName);
        noPhone = (EditText) findViewById(R.id.etPhone);

        mydb  = new DBHelper(this);
        Bundle extras = getIntent().getExtras();
        if(extras != null){
            int Value = extras.getInt("id");

            if(Value>0){
                //means this is the view part not the add contact part.
                Cursor rs = mydb.getData(Value);
                id_To_Update = Value;
                rs.moveToFirst();

                nim   = rs.getString(rs.getColumnIndex(DBHelper.MHS_COLUMN_NIM));
                name  = rs.getString(rs.getColumnIndex(DBHelper.MHS_COLUMN_NAMA));
                phone = rs.getString(rs.getColumnIndex(DBHelper.MHS_COLUMN_PHONE));
                if (!rs.isClosed()){
                    rs.close();
                }

                btnSimpan = (Button) findViewById(R.id.btn1);
                btnSimpan.setVisibility(View.INVISIBLE);
                btnSimpan.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(i);
                    }
                });

                noMhs.setText((CharSequence)nim);
                nama.setText((CharSequence)name);
                noPhone.setText((CharSequence)phone);

                noMhs.setFocusable(false);
                nama.setFocusable(false);
                noPhone.setFocusable(false);

                noMhs.setClickable(false);
                nama.setClickable(false);
                noPhone.setClickable(false);
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Inflate the menu; this adds to the action bar if it is present.
        Bundle extras = getIntent().getExtras();
        if (extras != null){
            int Value = extras.getInt("id");
            if(Value>0){
                getMenuInflater().inflate(R.menu.menu_display,menu);
            }else{
                getMenuInflater().inflate(R.menu.menu_main,menu);
            }
        }return true;
    }

    public void run(View view){
        if (noMhs.getText().toString().equals("")||
            nama.getText().toString().equals("")||
            noPhone.getText().toString().equals("")){
            Toast.makeText(getApplicationContext(),"Data Harus Diisi Semua!", Toast.LENGTH_LONG).show();
        }else{
            mydb.insertContact(noMhs.getText().toString(), nama.getText().toString(), noPhone.getText().toString());
            Toast.makeText(getApplicationContext(), "Insert Data Berhasil", Toast.LENGTH_LONG).show();

            Intent i = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(i);
        }
    }
}
