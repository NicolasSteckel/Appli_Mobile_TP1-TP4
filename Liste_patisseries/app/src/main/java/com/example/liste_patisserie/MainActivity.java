package com.example.liste_patisserie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

import java.util.ArrayList;
import android.os.Bundle;

import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends AppCompatActivity implements MyRecyclerViewAdapter.ItemClickListener {
    MyRecyclerViewAdapter adapter;

    List<String> patisseriesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        patisseriesList = new ArrayList<>();
        patisseriesList.add("Pain au chocolat");
        patisseriesList.add("Eclair");
        patisseriesList.add("Tartelette");
        patisseriesList.add("Tarte au citron");
        patisseriesList.add("Croissant");
        patisseriesList.add("Cheesecake");


        RecyclerView recyclerView = findViewById(R.id.pastries);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyRecyclerViewAdapter(this, patisseriesList);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(View view, int position) {


        switch (position){
            case 0:
                fct_pain_choco();
                break;

            case 1:
                fct_eclair();
                break;

            case 2:
                fct_tartelette();
                break;

            case 3:
                fct_tarte_citr();
                break;

            case 4:
                fct_croissant();
                break;

            case 5:
                fct_cheesecake();
                break;

        }

    }

    public void fct_pain_choco(){
        String str_mer = getResources().getString(R.string.pain_choco_detail);
        Intent intent = new Intent(getApplicationContext(), patisserie_detail.class);
        intent.putExtra("message_key", str_mer);

        startActivity(intent);
    }

    public void fct_eclair(){
        String str_venus =getResources().getString(R.string.eclair_detail);
        Intent intent = new Intent(getApplicationContext(), patisserie_detail.class);
        intent.putExtra("message_key", str_venus);

        startActivity(intent);
    }

    public void fct_tartelette(){
        String str_terre =getResources().getString(R.string.tartelette_detail);
        Intent intent = new Intent(getApplicationContext(), patisserie_detail.class);
        intent.putExtra("message_key", str_terre);

        startActivity(intent);
    }

    public void fct_tarte_citr(){
        String str_mars =getResources().getString(R.string.tarte_citr_detail);
        Intent intent = new Intent(getApplicationContext(), patisserie_detail.class);
        intent.putExtra("message_key", str_mars);

        startActivity(intent);
    }

    public void fct_croissant(){
        String str_jup =getResources().getString(R.string.croissant_detail);
        Intent intent = new Intent(getApplicationContext(), patisserie_detail.class);
        intent.putExtra("message_key", str_jup);

        startActivity(intent);
    }

    public void fct_cheesecake(){
        String str_sat = getResources().getString(R.string.cheesecake_detail);
        Intent intent = new Intent(getApplicationContext(), patisserie_detail.class);
        intent.putExtra("message_key", str_sat);

        startActivity(intent);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        MenuItem item = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
               adapter.getFilter().filter(newText);
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }
}