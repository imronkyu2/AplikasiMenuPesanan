package com.example.aplikasimenupesanan;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "menucafe.db";
    private static final int DATABASE_VERSION = 1;
    public DataHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        // TODO Auto-generated constructor stub
    }


    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS jenis");
        db.execSQL("CREATE TABLE jenis(kd_jenis text primary key, nama_jenis text)");
        db.execSQL("INSERT INTO jenis (kd_jenis, nama_jenis) VALUES('MN', 'Minuman')");
        db.execSQL("INSERT INTO jenis (kd_jenis, nama_jenis) VALUES ('MK','Makanan')");



        db.execSQL("DROP TABLE IF EXISTS menu");
        db.execSQL("CREATE TABLE menu(kd_menu text primary key, nama_menu text, detail text, harga integer, kd_jenis text)");
        db.execSQL("INSERT INTO menu (kd_menu , nama_menu , detail, harga, kd_jenis) VALUES('Min1','Kopi Hitam','Kopi hitam dengan teknik espresso dimana biji kopi yang digunakan berasal dari Aceh Gayo disajikan dengan gula terpisah.','10000','MN')");
        db.execSQL("INSERT INTO menu (kd_menu , nama_menu , detail, harga, kd_jenis) VALUES('Min2','Cappucino','Paduan kopi dengan buih susu kental serta  menggunakan sirup karamel, dimana biji kopi yang disajikan berasal dari Gunung Sahari.','15000','MN')");
        db.execSQL("INSERT INTO menu (kd_menu , nama_menu , detail, harga, kd_jenis) VALUES('Min3','Thai Tee','Minuman teh khas dari negara Thailand dapat anda coba kenikmatannya di kafe kami.','12000','MN')");

        db.execSQL("INSERT INTO menu (kd_menu , nama_menu , detail, harga, kd_jenis) VALUES('Mak1','Pisang Goreng','Terbuat dari pisang raja yang terkenal dengan kemanisannya, dengan paduan tepung terigu segiempat yang renyah.','3000','MK')");
        db.execSQL("INSERT INTO menu (kd_menu , nama_menu , detail, harga, kd_jenis) VALUES('Mak2','Bakwan','Makanan gorengan ini terbuat dari campuran sayuran pilihan segar yang dapat membuat lidah Anda.','2000','MK')");
        db.execSQL("INSERT INTO menu (kd_menu , nama_menu , detail, harga, kd_jenis) VALUES('Mak3','Nasi Goreng','Nasi goreng dengan pilihan bahan beras berkualitas dicampur dengan daging ayam segar, mempunyai rasa yang istimewa.','35000','MK')");
        db.execSQL("INSERT INTO menu (kd_menu , nama_menu , detail, harga, kd_jenis) VALUES('Mak4','Mie Goreng','Mie gorang bangka ini dibuat dari bahan berkualitas tinggi, dicampur dengan daging sapi olahan yang nikmat.','30000','MK')");


        db.execSQL("DROP TABLE IF EXISTS pesanan");
        db.execSQL("CREATE TABLE pesanan(kd_pesanan text primary key, tanggal text, jam text, nomor_meja integer)");
        db.execSQL("INSERT INTO pesanan(kd_pesanan, tanggal, jam, nomor_meja) VALUES ('P01', '03-10-2019', '10:00','1')");
        db.execSQL("INSERT INTO pesanan(kd_pesanan, tanggal, jam, nomor_meja) VALUES ('P02', '04-10-2019', '09:20','2')");
        db.execSQL("INSERT INTO pesanan(kd_pesanan, tanggal, jam, nomor_meja) VALUES ('P03', '05-10-2019', '08:00','3')");
        db.execSQL("INSERT INTO pesanan(kd_pesanan, tanggal, jam, nomor_meja) VALUES ('P04', '06-10-2019', '13:00','4')");

        db.execSQL("DROP TABLE IF EXISTS pesanan_detail");
        db.execSQL("CREATE TABLE pesanan_detail(kd_pes_detail text primary key,kd_pesanan text, kd_menu text,qtt integer)");
        db.execSQL("INSERT INTO pesanan_detail(kd_pes_detail, kd_pesanan, kd_menu, qtt) VALUES ('KPD01', 'P01', 'Min1','1')");
        db.execSQL("INSERT INTO pesanan_detail(kd_pes_detail, kd_pesanan, kd_menu, qtt) VALUES ('KPD02', 'P02', 'Mak2','2')");
        db.execSQL("INSERT INTO pesanan_detail(kd_pes_detail, kd_pesanan, kd_menu, qtt) VALUES ('KPD03', 'P03', 'Mak3','2')");
        db.execSQL("INSERT INTO pesanan_detail(kd_pes_detail, kd_pesanan, kd_menu, qtt) VALUES ('KPD04', 'P04', 'Min2','2')");
    }

    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS jenis");
        db.execSQL("DROP TABLE IF EXISTS menu");
        db.execSQL("DROP TABLE IF EXISTS pesanan");
        db.execSQL("DROP TABLE IF EXISTS pesanan_detail");
        onCreate(db);
    }
}