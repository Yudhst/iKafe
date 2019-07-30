package com.example.ikafe;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Calendar;

public class PesanActivity extends AppCompatActivity {

    private Spinner dropKdMenu;
    private Button btnInput;
    private EditText edtTanggal, edtJam, edtNoMeja, edtHarga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesan);

        String[] arrMenu = {" -> Pilih Menu","B01 - Kopi Hitam","B02 - Cappuccino","M03 - Sparkling Tea","F01 - Batagor","F02 - Cireng","F03 - Nasi Goreng","D01 - Cheese Cake","D02 - Black Salad"};

        dropKdMenu = findViewById(R.id.dropKdMenu);
        btnInput = findViewById(R.id.btnTambah);

        edtTanggal = findViewById(R.id.edtTanggal);
        edtJam = findViewById(R.id.edtJam);
        edtNoMeja = findViewById(R.id.edtNoMeja);
        edtHarga = findViewById(R.id.edtHarga);

        ArrayAdapter<String> menuAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, arrMenu);
        menuAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dropKdMenu.setAdapter(menuAdapter);

        btnInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isEmpty()){
                    Toast.makeText(PesanActivity.this, "Pesanan Dimasukkan", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(PesanActivity.this, MainActivity.class));
                    finish();
                }else {
                    Toast.makeText(PesanActivity.this, "Isi semua data!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    boolean isEmpty(){
        return (TextUtils.isEmpty(edtHarga.getText().toString()) || TextUtils.isEmpty(edtJam.getText().toString()) || TextUtils.isEmpty(edtNoMeja.getText().toString()) || TextUtils.isEmpty(edtTanggal.getText().toString()));
    }
}
