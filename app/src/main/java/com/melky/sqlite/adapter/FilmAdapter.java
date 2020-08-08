package com.melky.sqlite.adapter;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.melky.sqlite.R;
import com.melky.sqlite.UpdateOrDeleteActivity;
import com.melky.sqlite.model.DatabaseHelper;
import com.melky.sqlite.model.Film;

import java.util.List;

/**
 * Created by Belal on 9/30/2017.
 */

public class FilmAdapter extends ArrayAdapter<Film> {

    Context mCtx;
    int listLayoutRes;
    List<Film> filmList;
    DatabaseHelper mDatabase;

    public FilmAdapter(Context mCtx, int listLayoutRes, List<Film> employeeList, DatabaseHelper mDatabase) {
        super(mCtx, listLayoutRes, employeeList);

        this.mCtx = mCtx;
        this.listLayoutRes = listLayoutRes;
        this.filmList = employeeList;
        this.mDatabase = mDatabase;
    }
    @Override
    public View getView(int position,  View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(listLayoutRes, null);

        //getting employee of the specified position
        final Film film = filmList.get(position);


        //getting views
        TextView textViewName = view.findViewById(R.id.textViewName);
        TextView textViewSalary = view.findViewById(R.id.textViewSalary);
        TextView textViewJoiningDate = view.findViewById(R.id.textViewJoiningDate);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mCtx, film.getJudul_film(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(mCtx, UpdateOrDeleteActivity.class);
                intent.putExtra("id", film.getId());
                intent.putExtra("judul_film", film.getJudul_film());
                intent.putExtra("genre", film.getGenre());
                intent.putExtra("release", film.getTahun_release());
                mCtx.startActivity(intent);

            }
        });

        //adding data to views
        textViewName.setText(film.getJudul_film());
        textViewSalary.setText(String.valueOf(film.getGenre()));
        textViewJoiningDate.setText(film.getTahun_release().toString());


        return view;
    }
}
