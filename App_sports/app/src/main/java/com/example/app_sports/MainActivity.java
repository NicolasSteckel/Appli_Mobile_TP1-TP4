package com.example.app_sports;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView badminton;
    private TextView kungfu;
    private TextView behourd;
    private TextView basketball;
    private TextView baseball;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        badminton = findViewById(R.id.textView);
        kungfu = findViewById(R.id.textView2);
        behourd = findViewById(R.id.textView3);
        basketball = findViewById(R.id.textView4);
        baseball = findViewById(R.id.textView5);


        String str_bad = getResources().getString(R.string.badminton_text);
        String str_kf =getResources().getString(R.string.kungfu_text);
        String str_bhd =getResources().getString(R.string.behourd_text);
        String str_basket =getResources().getString(R.string.basketball_text);
        String str_baseball =getResources().getString(R.string.baseball_text);


        badminton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), detail_activity.class);
                intent.putExtra("message_key", str_bad);

                startActivity(intent);
            }
        });

        kungfu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), detail_activity.class);
                intent.putExtra("message_key", str_kf);

                startActivity(intent);

            }
        });

        behourd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), detail_activity.class);
                intent.putExtra("message_key", str_bhd);

                startActivity(intent);

            }
        });

        basketball.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), detail_activity.class);
                intent.putExtra("message_key", str_basket);

                startActivity(intent);

            }
        });

        baseball.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), detail_activity.class);
                intent.putExtra("message_key", str_baseball);

                startActivity(intent);

            }
        });


    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}