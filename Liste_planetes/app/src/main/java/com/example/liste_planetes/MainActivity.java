package com.example.liste_planetes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import java.util.ArrayList;
import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import android.view.View;


public class MainActivity extends AppCompatActivity implements MyRecyclerViewAdapter.ItemClickListener {
    MyRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<String> planetes_noms = new ArrayList<>();
        planetes_noms.add("Mercure");
        planetes_noms.add("Venus");
        planetes_noms.add("Terre");
        planetes_noms.add("Mars");
        planetes_noms.add("Jupiter");
        planetes_noms.add("Saturne");
        planetes_noms.add("Uranus");
        planetes_noms.add("Neptune");




        RecyclerView recyclerView = findViewById(R.id.planetes);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyRecyclerViewAdapter(this, planetes_noms);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(View view, int position) {
        //adapter.getItem(position);
        switch (position){
            case 0:
                fct_mercure();
                break;

            case 1:
                fct_venus();
                break;

            case 2:
                fct_terre();
                break;

            case 3:
                fct_mars();
                break;

            case 4:
                fct_jupiter();
                break;

            case 5:
                fct_saturne();
                break;

            case 6:
                fct_uranus();
                break;

            case 7:
                fct_neptune();
                break;
        }

    }

    public void fct_mercure(){
        String str_mer = getResources().getString(R.string.mercure_detail);
        Intent intent = new Intent(getApplicationContext(), planetes_detail.class);
        intent.putExtra("message_key", str_mer);

        startActivity(intent);
    }

    public void fct_venus(){
        String str_venus =getResources().getString(R.string.venus_detail);
        Intent intent = new Intent(getApplicationContext(), planetes_detail.class);
        intent.putExtra("message_key", str_venus);

        startActivity(intent);
    }

    public void fct_terre(){
        String str_terre =getResources().getString(R.string.terre_detail);
        Intent intent = new Intent(getApplicationContext(), planetes_detail.class);
        intent.putExtra("message_key", str_terre);

        startActivity(intent);
    }

    public void fct_mars(){
        String str_mars =getResources().getString(R.string.mars_detail);
        Intent intent = new Intent(getApplicationContext(), planetes_detail.class);
        intent.putExtra("message_key", str_mars);

        startActivity(intent);
    }

    public void fct_jupiter(){
        String str_jup =getResources().getString(R.string.jupiter_detail);
        Intent intent = new Intent(getApplicationContext(), planetes_detail.class);
        intent.putExtra("message_key", str_jup);

        startActivity(intent);
    }

    public void fct_saturne(){
        String str_sat = getResources().getString(R.string.saturne_detail);
        Intent intent = new Intent(getApplicationContext(), planetes_detail.class);
        intent.putExtra("message_key", str_sat);

        startActivity(intent);
    }

    public void fct_uranus(){
        String str_uranus = getResources().getString(R.string.uranus_detail);
        Intent intent = new Intent(getApplicationContext(), planetes_detail.class);
        intent.putExtra("message_key", str_uranus);

        startActivity(intent);
    }

    public void fct_neptune(){
        String str_nept = getResources().getString(R.string.neptune_detail);
        Intent intent = new Intent(getApplicationContext(), planetes_detail.class);
        intent.putExtra("message_key", str_nept);

        startActivity(intent);
    }

}