package com.wtech.answeringcall;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CheckInActivity extends AppCompatActivity {
    private Button btConfirmar;
    private Button btCancelar;

    private TextView txtId;
    private TextView txtNome;
    private TextView txtData;
    private TextView txtHora;
    private TextView txtStatus;

    //Presenca presenca = getIntent().getExtras().getParcelable("presenca");
    private Presenca presenca = new Presenca();

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkin);

        checkIn();

        btConfirmar = (Button) findViewById(R.id.btnConfirmar);
        btConfirmar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                intent = new Intent(CheckInActivity.this,ResultActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btCancelar = (Button) findViewById(R.id.btnCancelar);
        btCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(CheckInActivity.this,RegisterActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
    public String buscarNome(int id){
        String nome = "Weldis Alves da Silva";
        return nome;
    }

    public void checkIn(){
        txtId = (TextView) findViewById(R.id.txtViewId);
        txtNome = (TextView) findViewById(R.id.txtViewNome);
        txtData = (TextView) findViewById(R.id.txtViewData);
        txtHora = (TextView) findViewById(R.id.txtViewHora);
        txtStatus = (TextView) findViewById(R.id.txtViewStatus);

        String nome = buscarNome(123);
        presenca.setNome(nome);

//        txtId.setText(presenca.getIdParticipante());
        txtNome.setText(presenca.getNome());
//        txtData.setText(presenca.getData());
//        txtHora.setText(presenca.getHora());
//        txtStatus.setText(presenca.getStatus());
    }
}