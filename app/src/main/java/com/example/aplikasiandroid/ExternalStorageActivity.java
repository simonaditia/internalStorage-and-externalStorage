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

public class ExternalStorageActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String FILENAME = "myFile.txt";
    public static final String FILEPATH = "MyFileDir";
    Button btn_buatE, btn_ubahE, btn_bacaE, btn_hapusE;
    EditText editInputE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_external_storage);

        btn_buatE = (Button) findViewById(R.id.btn_buatE);
        btn_ubahE = (Button) findViewById(R.id.btn_ubahE);
        btn_bacaE= (Button) findViewById(R.id.btn_bacaE);
        btn_hapusE = (Button) findViewById(R.id.btn_hapusE);

        btn_buatE.setOnClickListener(this);
        btn_ubahE.setOnClickListener(this);
        btn_bacaE.setOnClickListener(this);
        btn_hapusE.setOnClickListener(this);

        editInputE = (EditText) findViewById(R.id.editInputE);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.btn_buatE:
                buatFileE();
                break;
            case R.id.btn_ubahE:
                ubahFileE();
                break;
            case R.id.btn_bacaE:
                bacaFileE();
                break;
            case R.id.btn_hapusE:
                hapusFileE();
                break;
        }
    }

    void buatFileE() {
        String contentData = editInputE.getText().toString();
        File file = new File(getExternalFilesDir(FILEPATH),FILENAME);

        FileOutputStream fileOutputStream = null;

        try {
            Log.d(FILENAME, "SUKSES");
            file.createNewFile();
            fileOutputStream = new FileOutputStream(file,false);
            fileOutputStream.write(contentData.getBytes());
            fileOutputStream.flush();
            fileOutputStream.close();
            Toast.makeText(this, "Tersimpan di SD Card", Toast.LENGTH_SHORT).show();
        } catch (IOException ex) {
            Toast.makeText(this, "Error : " + ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    void bacaFileE() {
        File file = new File(getExternalFilesDir(FILEPATH),FILENAME);
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
                editInputE.setText(text);
            } catch (IOException ex) {
                Toast.makeText(this, "Error : " + ex.getMessage(), Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "File Tidak Ditemukan", Toast.LENGTH_SHORT).show();
        }
    }

    void hapusFileE() {
        File file = new File(getExternalFilesDir(FILEPATH),FILENAME);
        if(file.exists()) {
            file.delete();
            Toast.makeText(this, "Berhasil dihapus", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "File Tidak Ditemukan", Toast.LENGTH_SHORT).show();
        }
    }

    void ubahFileE() {
        String contentData = editInputE.getText().toString();
        File file = new File(getExternalFilesDir(FILEPATH),FILENAME);

        FileOutputStream fileOutputStream = null;

        try {
            file.createNewFile();
            fileOutputStream = new FileOutputStream(file,false);
            fileOutputStream.write(contentData.getBytes());
            fileOutputStream.flush();
            fileOutputStream.close();
            Toast.makeText(this, "Data berhasil diubah ", Toast.LENGTH_SHORT).show();
        } catch (IOException ex) {
            Toast.makeText(this, "Error : " + ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}