package com.melky.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.melky.sqlite.R;
import com.melky.sqlite.model.DatabaseHelper;

public class TambahActivity extends AppCompatActivity {
    DatabaseHelper myDb;
    Button btnAddData;
    EditText judul, genre, release;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah);
        myDb = new DatabaseHelper(this);
        judul = (EditText)findViewById(R.id.et_judul);
        genre = (EditText)findViewById(R.id.et_genre);
        release = (EditText)findViewById(R.id.et_rilis);
        btnAddData = (Button)findViewById(R.id.btn_insert);
        AddData();
    }

    public void AddData() {

        btnAddData.setOnClickListener(

                new View.OnClickListener() {

                    @Override

                    public void onClick(View v) {

                        boolean isInserted = myDb.insertData(judul.getText().toString(),

                                genre.getText().toString(),

                                release.getText().toString() );

                        if(isInserted == true){
                            dataSaved();
                            Toast.makeText(TambahActivity.this,"Data Iserted",Toast.LENGTH_LONG).show();
                        }else

                            Toast.makeText(TambahActivity.this,"Data Not Iserted",Toast.LENGTH_LONG).show();

                    }

                }

        );

    }

    public void dataSaved() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}