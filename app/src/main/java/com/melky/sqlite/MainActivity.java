package com.melky.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.melky.sqlite.adapter.FilmAdapter;
import com.melky.sqlite.model.DatabaseHelper;
import com.melky.sqlite.model.Film;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper myDb;
    Button btnIntentAdd, btnRefresh;
    FilmAdapter adapter;
    ListView listViewFilm;

    private String[] mahasiswa = {"Wildan","Taufan","Adibil;","Hari","Adam",
            "Hermawan","Indra","Widi","Anisa","Hani"};

    //ArrayList digunakan Untuk menampung Data mahasiswa
    private ArrayList<String> data;
    List<Film> filmList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb = new DatabaseHelper(this);
        btnIntentAdd = (Button)findViewById(R.id.bt_tambah);
        btnRefresh = findViewById(R.id.btn_refresh);

        listViewFilm = findViewById(R.id.list_film);
        filmList = new ArrayList<>();

        viewAllData();

        btnIntentAdd.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        moveIntent();
                    }
                }
        );

        btnRefresh.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
//                        viewAllData();

                    }
                }
        );
    }



    public void moveIntent() {
        Intent intent = new Intent(this, TambahActivity.class);
        startActivity(intent);
    }

    private void viewAllData() {
        Cursor res = myDb.getAllData();

        if (res.moveToFirst()) {
            do {
                filmList.add( new Film(
                        res.getInt(0),
                        res.getString(1),
                        res.getString(2),
                        res.getInt(3)
                ));
            } while (res.moveToNext());
            }
        res.close();

        adapter = new FilmAdapter(this, R.layout.list_film_layout, filmList, myDb);
        listViewFilm.setAdapter(adapter);

        }
    }

