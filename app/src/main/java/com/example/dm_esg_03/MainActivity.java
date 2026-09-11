package com.example.dm_esg_03;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //1. declarar variables para interactuar con las vistas
    // vistas, boton, texto, entradas de tecto layout
    EditText etPies, etMetros;
    Button btnPies, btnMetros;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //2. Enlazar variables con vistas - erros nullpointer

        etMetros = findViewById(R.id.etMetros);
        etPies = findViewById(R.id.etPies);

        btnPies = findViewById(R.id.btnPies);
        btnMetros = findViewById(R.id.btnMetros);

        //3. Procesos varios

        btnMetros.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        // view - puede ser el btnMetos o btnPies
        // saber sobre que boton ser le dio click
        if(view.getId()==R.id.btnMetros){
            //En caso de ser click sobre el boton pies
            convertirMetroPies();
        } else {
            // En caso de dar click sobre metros
            convertirPiesMetros();
        }
    }

    public void convertirMetroPies(){
        double metros = Double.parseDouble(etMetros.getText().toString());
        double pies = metros * 3.28084;
        etPies.setText(String.valueOf(pies));

    }

    public void convertirPiesMetros(){
        double pies = Double.parseDouble(etPies.getText().toString());
        double metros = pies / 3.28084;
        etMetros.setText(String.valueOf(metros));

    }
}