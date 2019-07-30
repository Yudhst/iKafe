package com.example.ikafe;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class PesanActivity extends AppCompatActivity {

    private Spinner dropKdMenu;
    private Button btnInput;
    private EditText edtTanggal, edtJam, edtNoMeja, edtHarga;
    private Calendar myCalendar;
    private
    DatePickerDialog.OnDateSetListener date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesan);
        myCalendar = Calendar.getInstance();
        String[] arrMenu = {" -> Pilih Menu","B01 - Kopi Hitam","B02 - Cappuccino","M03 - Sparkling Tea","F01 - Batagor","F02 - Cireng","F03 - Nasi Goreng","D01 - Cheese Cake","D02 - Black Salad"};

        dropKdMenu = findViewById(R.id.dropKdMenu);
        btnInput = findViewById(R.id.btnTambah);

        edtTanggal = findViewById(R.id.edtTanggal);
        edtJam = findViewById(R.id.edtJam);
        edtNoMeja = findViewById(R.id.edtNoMeja);
        edtHarga = findViewById(R.id.edtHarga);

        date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
                edtTanggal.setText(sdf.format(myCalendar.getTime()));
            }
        };

        ArrayAdapter<String> menuAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, arrMenu);
        menuAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dropKdMenu.setAdapter(menuAdapter);

        edtTanggal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(PesanActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        edtJam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar mCurtime = Calendar.getInstance();
                int hour = mCurtime.get(Calendar.HOUR_OF_DAY);
                int minute = mCurtime.get(Calendar.MINUTE);
                TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(PesanActivity.this, new TimePickerDialog.OnTimeSetListener() {

                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        edtJam.setText(selectedHour + ":" + selectedMinute);
                    }
                }, hour, minute, true);
                mTimePicker.setTitle("Select Time");
                mTimePicker.show();
            }
        });

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
