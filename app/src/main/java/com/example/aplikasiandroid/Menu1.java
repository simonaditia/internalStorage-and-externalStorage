package com.example.aplikasiandroid;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Menu1 extends AppCompatActivity {

    ActionBar actionBar;
    EditText txt_ndepan, txt_nbelakang, txt_tempatlahir, txt_alamat, txt_hobi;
    Spinner spn_jkelamin;
    Button btn_tgllahir, tampilkan;
    TextView tampil;
    private int tahun, bulan, hari;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu1);

        actionBar = getSupportActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        txt_ndepan = (EditText)findViewById(R.id.txt_ndepan);
        txt_nbelakang = (EditText)findViewById(R.id.txt_nbelakang);
        spn_jkelamin = (Spinner)findViewById(R.id.spn_jkelamin);
        txt_tempatlahir = (EditText)findViewById(R.id.txt_tempatlahir);
        btn_tgllahir = (Button)findViewById(R.id.btn_tgllahir);
        txt_alamat = (EditText)findViewById(R.id.txt_alamat);
        txt_hobi = (EditText)findViewById(R.id.txt_hobi);

        tampilkan = (Button)findViewById(R.id.btn_tampilkan);
        tampil = (TextView)findViewById(R.id.txt_tampil);

        List<String> listKelamin = new ArrayList<String>();
        listKelamin.add("Laki-laki");
        listKelamin.add("Perempuan");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listKelamin);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spn_jkelamin.setAdapter(adapter);

        btn_tgllahir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                tahun = cal.get(Calendar.YEAR);
                bulan = cal.get(Calendar.MONTH);
                hari = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dateDialog = new DatePickerDialog(Menu1.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        btn_tgllahir.setText(String.valueOf(dayOfMonth) + "-" + String.valueOf(month+1) + "-" + String.valueOf(year));
                    }
                }, tahun, bulan, hari);
//                dateDialog.setTitle("Pilih Tanggal Lahir");
                dateDialog.show();
            }
        });

        tampilkan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tampil.setText("Halo saya seorang " + spn_jkelamin.getSelectedItem().toString() + " bernama " + txt_ndepan.getText().toString() + " " +
                        txt_nbelakang.getText().toString() + " lahir di " + txt_tempatlahir.getText().toString() + ", " + btn_tgllahir.getText().toString() +
                        " tinggal di " + txt_alamat.getText().toString() + " dan hobi saya " + txt_hobi.getText().toString());
                Toast.makeText(Menu1.this,
                        "Halo saya seorang " + spn_jkelamin.getSelectedItem().toString() + " bernama " + txt_ndepan.getText().toString() + " " +
                                txt_nbelakang.getText().toString() + " lahir di " + txt_tempatlahir.getText().toString() + ", " + btn_tgllahir.getText().toString() +
                                " tinggal di " + txt_alamat.getText().toString() + " dan hobi saya " + txt_hobi.getText().toString(),
                        Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}