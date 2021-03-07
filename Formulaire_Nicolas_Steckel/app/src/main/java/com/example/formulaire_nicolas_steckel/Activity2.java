package com.example.formulaire_nicolas_steckel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    TextView receiver_msg;
    TextView receiver_msgP;
    TextView receiver_msgA;
    TextView receiver_msgM;
    TextView receiver_G;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        receiver_msg = (TextView)findViewById(R.id.nom_recu);
        receiver_msgP = (TextView)findViewById(R.id.prenom_recu);
        receiver_msgA = (TextView)findViewById(R.id.adresse_recu);
        receiver_msgM = (TextView)findViewById(R.id.mail_recu);
        receiver_G = (TextView)findViewById(R.id.genre_recu);


        Intent intent = getIntent();

        String str = intent.getStringExtra("message_key");
        String strP = intent.getStringExtra("message_keyP");
        String strA = intent.getStringExtra("message_keyA");
        String strM = intent.getStringExtra("message_keyM");

        String stG = intent.getStringExtra("message_radG");
        receiver_G.setText(stG);


        receiver_msg.setText(str);
        receiver_msgP.setText(strP);
        receiver_msgA.setText(strA);
        receiver_msgM.setText(strM);
    }
}