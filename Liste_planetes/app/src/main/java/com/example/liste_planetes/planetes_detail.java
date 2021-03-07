package com.example.liste_planetes;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.os.Bundle;

public class planetes_detail extends AppCompatActivity {
    private Button retour;
    TextView detail_msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planetes_detail);

        detail_msg = (TextView)findViewById(R.id.text_detail);
        retour = findViewById(R.id.button_back);

        retour.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }

        });

        Intent intent = getIntent();
        Bundle b = intent.getExtras();

        if(b!=null)        {
            String j =(String) b.get("message_key");
            detail_msg.setText(j);
        }

    }
}