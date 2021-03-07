package com.example.formulaire_nicolas_steckel;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Patterns;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private TextInputLayout textInputNom;
    private TextInputLayout textInputPrenom;
    private TextInputLayout textInputAdresse;
    private TextInputLayout textInputMail;
    private Button send_button;
    private RadioGroup radioGroup;
    private RadioButton radioButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        send_button = findViewById(R.id.button_validate);
        textInputNom = findViewById(R.id.text_input_nom);
        textInputPrenom = findViewById(R.id.text_input_prenom);
        textInputAdresse = findViewById(R.id.text_input_adresse);
        textInputMail = findViewById(R.id.text_input_mail);

        send_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String str = textInputNom.getEditText().getText().toString();
                String strP = textInputPrenom.getEditText().getText().toString();
                String strA = textInputAdresse.getEditText().getText().toString();
                String strM = textInputMail.getEditText().getText().toString();
                Intent intent = new Intent(getApplicationContext(), Activity2.class);

                intent.putExtra("message_key", str);
                intent.putExtra("message_keyP", strP);
                intent.putExtra("message_keyA", strA);
                intent.putExtra("message_keyM", strM);

                RadioGroup radioGroup = findViewById(R.id.groupe_genre);
                int selectedRadioButtonId = radioGroup.getCheckedRadioButtonId();
                if (selectedRadioButtonId != -1) {
                    radioButton = (RadioButton) findViewById(selectedRadioButtonId);
                    String selectedRbText = radioButton.getText().toString();
                    intent.putExtra("message_radG", selectedRbText);
                }

                startActivity(intent);
            }
        });

    }


    private boolean validationNom() {
        String emailInput = textInputNom.getEditText().getText().toString().trim();
        if (emailInput.isEmpty()){
            textInputNom.setError("Champ obligatoire");
            return false;
        } else {
            textInputNom.setError(null);
            return true;
        }
    }

    private boolean validationPrenom() {
        String emailInput = textInputPrenom.getEditText().getText().toString().trim();
        if (emailInput.isEmpty()){
            textInputPrenom.setError("Champ obligatoire");
            return false;
        } else {
            textInputPrenom.setError(null);
            return true;
        }
    }

    private boolean validationAdresse() {
        String emailInput = textInputAdresse.getEditText().getText().toString().trim();
        if (emailInput.isEmpty()){
            textInputAdresse.setError("Champ obligatoire");
            return false;
        } else {
            textInputAdresse.setError(null);
            return true;
        }
    }


    private boolean validationEmail() {
        String emailInput = textInputMail.getEditText().getText().toString().trim();
        if (emailInput.isEmpty()){
            textInputMail.setError("Champ obligatoire");
            return false;
        }else if(!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()){
            textInputMail.setError("Veuillez entrer une adresse mail valide");
            return false;
        } else {
            textInputMail.setError(null);
            return true;
        }
    }

    public void confirmationInput(View v){
        if(!validationEmail() | !validationNom() | !validationPrenom() | !validationAdresse()){
            return;
        }
        String input = "Nom : "+textInputNom.getEditText().getText().toString();
        input += "\n";
        input = "Prénom : "+textInputPrenom.getEditText().getText().toString();
        input += "\n";
        input = "Adresse : "+textInputAdresse.getEditText().getText().toString();
        input += "\n";
        input = "Email : "+textInputMail.getEditText().getText().toString();
        input += "\n";


        Toast.makeText(this, input, Toast.LENGTH_SHORT).show();
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