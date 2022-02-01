package com.example.aplikasimenupesanan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void bt_katagori(View view) {
        Intent i = new Intent(MainActivity.this,ActivityKatagori.class);
        startActivity(i);
    }

    public void bt_cave(View view) {
        Intent i = new Intent(MainActivity.this,MenuCafe.class);
        startActivity(i);
    }

    public void bt_pesanan(View view) {
        Intent i = new Intent(MainActivity.this,ActivityPesanan.class);
        startActivity(i);
    }

    public void bt_pes_detail(View view) {
        Intent i = new Intent(MainActivity.this,PesananDetail.class);
        startActivity(i);
    }
}
