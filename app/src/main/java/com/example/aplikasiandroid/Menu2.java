package com.example.aplikasiandroid;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Menu2 extends AppCompatActivity {

    ActionBar actionBar;
    EditText input_pertama, input_kedua;
    Button btn_tambah, btn_kurang, btn_kali, btn_bagi, btn_mod, btn_bersih;
    TextView txt_hasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu2);

        actionBar = getSupportActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        input_pertama = (EditText) findViewById(R.id.input_pertama);
        input_kedua = (EditText) findViewById(R.id.input_kedua);
        txt_hasil = (TextView) findViewById(R.id.txt_hasil);
        btn_tambah = (Button) findViewById(R.id.btn_tambah);
        btn_kurang = (Button) findViewById(R.id.btn_kurang);
        btn_kali = (Button) findViewById(R.id.btn_kali);
        btn_bagi = (Button) findViewById(R.id.btn_bagi);
        btn_mod = (Button) findViewById(R.id.btn_mod);
        btn_bersih = (Button) findViewById(R.id.btn_bersihkan);

        btn_tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double pertama = Double.parseDouble(input_pertama.getText().toString());//toString() -> dari string ke int
                double kedua = Double.parseDouble(input_kedua.getText().toString());

                double hasil = pertama + kedua;
                txt_hasil.setText(String.valueOf(hasil));//convert dari int ke string
            }
        });

        btn_kurang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double pertama = Double.parseDouble(input_pertama.getText().toString());
                double kedua = Double.parseDouble(input_kedua.getText().toString());

                double hasil = pertama - kedua;
                txt_hasil.setText(String.valueOf(hasil));
            }
        });

        btn_kali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double pertama = Double.parseDouble(input_pertama.getText().toString());
                double kedua = Double.parseDouble(input_kedua.getText().toString());

                double hasil = pertama * kedua;
                txt_hasil.setText(String.valueOf(hasil));
            }
        });

        btn_bagi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double pertama = Double.parseDouble(input_pertama.getText().toString());
                double kedua = Double.parseDouble(input_kedua.getText().toString());

                if(kedua == 0) {
                    Toast.makeText(Menu2.this, "Can't divide by zero", Toast.LENGTH_LONG).show();
                    txt_hasil.setText("Can't divide by zero");
                }

                double hasil = pertama / kedua;
                txt_hasil.setText(String.valueOf(hasil));
            }
        });

        btn_mod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double pertama = Double.parseDouble(input_pertama.getText().toString());
                double kedua = Double.parseDouble(input_kedua.getText().toString());

                double hasil = pertama % kedua;
                txt_hasil.setText(String.valueOf(hasil));
            }
        });

        btn_bersih.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input_pertama.setText("");
                input_kedua.setText("");
                txt_hasil.setText("0");
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