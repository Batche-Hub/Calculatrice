package com.example.badad_tp6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button allerCalculatrice;
    private EditText resultatCalcul;
    private boolean isResultWasSent = false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        allerCalculatrice = findViewById(R.id.buttonAllerCalculatrice);
        allerCalculatrice.setOnClickListener(envoyerListener);
        resultatCalcul = findViewById(R.id.editTextResultatCalcul);


    }

    private View.OnClickListener envoyerListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            allerCalcultrice();
        }
    };

    private void allerCalcultrice(){
            Intent intent = new Intent(this, CalculatriceActivity.class);
            startActivityForResult(intent, 2);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode==2)
        {
            String resultatStr = data.getStringExtra("RESULTAT");
            resultatCalcul.setText(resultatStr);
            isResultWasSent = true;
        }
        if (resultCode == 1) {
            String resultatStr = data.getStringExtra("NORESULTAT");
            resultatCalcul.setText(resultatStr);
            isResultWasSent = false;
        }
    }

}
