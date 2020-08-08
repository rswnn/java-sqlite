package com.melky.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.melky.sqlite.model.DatabaseHelper;

public class UpdateOrDeleteActivity extends AppCompatActivity {

    DatabaseHelper myDb;
    Bundle bundle;
    Integer id, release;
    String id_temp, judul, genre;
    EditText judulE, genreE, releaseE;
    Button btnUpdateData, btnDeleteData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_or_delete);
        myDb = new DatabaseHelper(this);
        judulE = (EditText)findViewById(R.id.et_judul_update);
        genreE = (EditText)findViewById(R.id.et_genre_update);
        releaseE = (EditText)findViewById(R.id.et_rilis_update);
        btnUpdateData = findViewById(R.id.btn_update);
        btnDeleteData = findViewById(R.id.btn_delete);
        getData();
        judulE.setText(judul);
        genreE.setText(genre);
        releaseE.setText(release.toString());

        updateData();
        deleteData();

    }

    private void getData() {
        bundle = getIntent().getExtras();
        id = bundle.getInt("id");
        judul = bundle.getString("judul_film");
        genre = bundle.getString("genre");
        release = bundle.getInt("release");

    }

    public void updateData() {

        btnUpdateData.setOnClickListener(

                new View.OnClickListener() {

                    @Override

                    public void onClick(View v) {

                        boolean isUpdate = myDb.updateData(id.toString(),

                                judulE.getText().toString(),

                                genreE.getText().toString(),

                                releaseE.getText().toString());

                        if(isUpdate == true){
                            Toast.makeText(UpdateOrDeleteActivity.this,"Data Updated",Toast.LENGTH_LONG).show();
                            dataSaved();
                        } else{
                            Toast.makeText(UpdateOrDeleteActivity.this,"Data Failed to Update",Toast.LENGTH_LONG).show();
                        }

                    }

                }

        );

    }

    public void deleteData() {

        btnDeleteData.setOnClickListener(

                new View.OnClickListener() {

                    @Override

                    public void onClick(View v) {

                        Integer deletedRows = myDb.deleteData(id.toString());
                        System.out.println(deletedRows);

                        if (deletedRows == 1){
                            dataSaved();
                        }

                        else {
                            Toast.makeText(UpdateOrDeleteActivity.this,"Data Failed to Deleted!",Toast.LENGTH_LONG).show();
                        }
                    }

                }

        );

    }
    public void dataSaved() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}