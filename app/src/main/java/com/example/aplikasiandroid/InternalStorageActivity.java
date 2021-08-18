package com.example.aplikasiandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class InternalStorageActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String FILENAME = "namafile.txt";
    Button btn_buat, btn_ubah, btn_baca, btn_hapus;
    EditText editInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internal_storage);

        btn_buat = (Button) findViewById(R.id.btn_buat);
        btn_ubah = (Button) findViewById(R.id.btn_ubah);
        btn_baca = (Button) findViewById(R.id.btn_baca);
        btn_hapus = (Button) findViewById(R.id.btn_hapus);

        btn_buat.setOnClickListener(this);
        btn_ubah.setOnClickListener(this);
        btn_baca.setOnClickListener(this);
        btn_hapus.setOnClickListener(this);

        editInput = (EditText) findViewById(R.id.editInput);

    }

    @Override
    public void onClick(View v) {
        switch  (v.getId()) {
            case R.id.btn_buat:
                buatFile();
                break;
            case R.id.btn_ubah:
                ubahFile();
                break;
            case R.id.btn_baca:
                bacaFile();
                break;
            case R.id.btn_hapus:
                hapusFile();
                break;
        }
    }

    void buatFile() {
        String contentData = editInput.getText().toString();
        File file = new File(getFilesDir(),FILENAME);

        FileOutputStream fileOutputStream = null;

        try {
            Log.d(FILENAME, "SUKSES");
            file.createNewFile();
            fileOutputStream = new FileOutputStream(file,false);
            fileOutputStream.write(contentData.getBytes());
            fileOutputStream.flush();
            fileOutputStream.close();
            Toast.makeText(this, "Tersimpan", Toast.LENGTH_SHORT).show();
        } catch (IOException ex) {
            Toast.makeText(this, "Error : " + ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    void bacaFile() {
        File file = new File(getFilesDir(),FILENAME);
        if(file.exists()) {
            StringBuilder text = new StringBuilder();
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                String line = bufferedReader.readLine();

                while (line != null) {
                    text.append(line);
                    line = bufferedReader.readLine();
                }
                bufferedReader.close();
                editInput.setText(text);
            } catch (IOException ex) {
                Toast.makeText(this, "Error : " + ex.getMessage(), Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "File Tidak Ditemukan", Toast.LENGTH_SHORT).show();
        }
    }

    void hapusFile() {
        File file = new File(getFilesDir(),FILENAME);
        if(file.exists()) {
            file.delete();
            Toast.makeText(this, "Berhasil dihapus", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "File Tidak Ditemukan", Toast.LENGTH_SHORT).show();
        }
    }

    void ubahFile() {
        String contentData = editInput.getText().toString();
        File file = new File(getFilesDir(),FILENAME);

        FileOutputStream fileOutputStream = null;

        try {
            file.createNewFile();
            fileOutputStream = new FileOutputStream(file,false);
            fileOutputStream.write(contentData.getBytes());
            fileOutputStream.flush();
            fileOutputStream.close();
            Toast.makeText(this, "Data berhasil diubah", Toast.LENGTH_SHORT).show();
        } catch (IOException ex) {
            Toast.makeText(this, "Error : " + ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}