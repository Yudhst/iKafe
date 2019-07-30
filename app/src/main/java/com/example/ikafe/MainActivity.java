package com.example.ikafe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.ikafe.adapters.MenuAdapter;
import com.example.ikafe.models.Menu;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MenuAdapter menuAdapter;
    private ArrayList<Menu> menuArrayList;
    public Button btnTambah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addMenu();
        recyclerView = findViewById(R.id.rvListMenu);
        menuAdapter = new MenuAdapter(menuArrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(menuAdapter);

        btnTambah = findViewById(R.id.btnAddPesan);

        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, PesanActivity.class));
            }
        });
    }

    public void addMenu(){
        menuArrayList = new ArrayList<>();
        menuArrayList.add(new Menu("B01","Minuman","Kopi Hitam", "Kopi Hitam dibuat dengan teknik espresso, dimana biji kopo yang digunakan yaitu berasal dari Aceh Gayo jenis Arabika, disajikan dengan gula terpisah", "Rp. 10000"));
        menuArrayList.add(new Menu("B02","Minuman","Cappucino", "Paduan Kopi dengan buih susu kental serta menggunakan sirup karamel, dimana biji kopi yang digunakan berasal dari Gunung Puntang Jawa Barat jenis Robusta", "Rp. 20000"));
        menuArrayList.add(new Menu("M03","Minuman","Sparkling Tea", "Minuman Teh yang menggunakan daun teh dari pegunungan daerah Garut dengan tambahan sari melati asli dan gula merah alami", "Rp. 15000"));
        menuArrayList.add(new Menu("F01","Makanan","Batagor", "Baso dan Tahu Goreng dengan sajian bumbu kacang dan kecap khas Bandung", "Rp. 25000"));
        menuArrayList.add(new Menu("F02","Makanan","Cireng", "Makanan ringan berupa tepung kanji goreng isi bahan dasar tempe fermentasi yang disebut Oncom, disajikan dengan bumbu kacang pedas", "Rp. 10000"));
        menuArrayList.add(new Menu("F03","Makanan","Nasi Goreng", "Nasi Goreng Ayam yang disajikan dengan Telur Mata Sapi disertai Sate Ayam", "Rp. 50000"));
        menuArrayList.add(new Menu("D01","Dessert","Cheese Cake", "Kue Tart 1 slice dengan bahan utama cream cheese dengan topping buah-buahan asli seperti Anggur, Jeruk, dan Kiwi", "Rp. 40000"));
        menuArrayList.add(new Menu("D02","Dessert","Black Salad", "Potongan buah-buahan segar yang terdiri dari Pepaya, Jambu, Melon, dan Mangga disajikan dengan bumbu rujak kacang pedas dan gula merah", "Rp. 30000"));
    }
}
