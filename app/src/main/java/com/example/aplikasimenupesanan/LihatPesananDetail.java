package com.example.aplikasimenupesanan;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LihatPesananDetail extends AppCompatActivity {

    protected Cursor cursor,cursor2,cursor3;
    DataHelper dbHelper;
    Button ton2;
    EditText etext1, etext2, etext3, etext4,etext5, etext6, etext7, etext8, etext9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_pesanan_detail);

        dbHelper = new DataHelper(this);
        etext1 = (EditText) findViewById(R.id.kolom_ed1);
        etext2 = (EditText) findViewById(R.id.kolom_ed2);
        etext3 = (EditText) findViewById(R.id.kolom_ed3);
        etext4 = (EditText) findViewById(R.id.kolom_ed4);
        etext5 = (EditText) findViewById(R.id.kolom_ed5);
        etext6 = (EditText) findViewById(R.id.kolom_ed6);
        etext7 = (EditText) findViewById(R.id.kolom_ed7);
        etext8 = (EditText) findViewById(R.id.kolom_ed8);
        etext9 = (EditText) findViewById(R.id.kolom_ed9);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM pesanan_detail WHERE kd_pes_detail = '" +getIntent().getStringExtra("comot")+"'",null);
        cursor.moveToFirst();
        if (cursor.getCount()>0)
        {
            cursor.moveToPosition(0);
            etext1.setText(cursor.getString(0).toString());
            etext2.setText(cursor.getString(1).toString());
            etext5.setText(cursor.getString(2).toString());
            etext8.setText(cursor.getString(3).toString());
        }
        cursor2 = db.rawQuery("SELECT * FROM pesanan WHERE kd_pesanan = '" + cursor.getString(1).toString()+"'",null);
        cursor2.moveToFirst();
        if (cursor2.getCount()>0)
        {
            cursor2.moveToPosition(0);
            etext4.setText(cursor2.getString(1).toString());
            etext3.setText(cursor2.getString(3).toString());
        }

        cursor3 = db.rawQuery("SELECT * FROM menu WHERE kd_menu  = '" + cursor.getString(2).toString()+"'",null);
        cursor3.moveToFirst();
        if (cursor3.getCount()>0)
        {
            cursor3.moveToPosition(0);
            etext6.setText(cursor3.getString(1).toString());
            etext7.setText(cursor3.getString(3).toString());

        }

        ton2 = (Button) findViewById(R.id.button1);
        ton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                finish();
            }
        });

        double JumlahPembelian =  Double.parseDouble(cursor.getString(3).toString());
        double HargaMenu =  Double.parseDouble(cursor3.getString(3).toString());
        double TotalHarga = JumlahPembelian * HargaMenu;
        etext9.setText(String.valueOf(Math.round(TotalHarga)));
    }
}