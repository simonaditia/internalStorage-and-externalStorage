package com.example.aplikasiandroid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.optionmenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==R.id.menu1) {
            startActivity(new Intent(this, Menu1.class));
        } else if (item.getItemId()==R.id.menu2) {
            startActivity(new Intent(this, Menu2.class));
        } else if (item.getItemId()==R.id.menu3) {
            startActivity(new Intent(this, Menu3.class));
        } else if (item.getItemId()==R.id.internalstorage) {
            startActivity(new Intent(this, InternalStorageActivity.class));
        } else if (item.getItemId()==R.id.externalstorage) {
            startActivity(new Intent(this, ExternalStorageActivity.class));
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void pindahmn1(View view) {
        Intent intent = new Intent(MainActivity.this, Menu1.class);
        startActivity(intent);
    }

    public void pindahmn2(View view) {
        Intent intent = new Intent(MainActivity.this, Menu2.class);
        startActivity(intent);
    }

    public void pindahmn3(View view) {
        Intent intent = new Intent(MainActivity.this, Menu3.class);
        startActivity(intent);
    }

    public void pindahinternal(View view) {
        Intent intent = new Intent(MainActivity.this, InternalStorageActivity.class);
        startActivity(intent);
    }

    public void keluar(View view) {
        moveTaskToBack(true);
    }


    public void pindahexternal(View view) {
        Intent intent = new Intent(MainActivity.this, ExternalStorageActivity.class);
        startActivity(intent);
    }
}