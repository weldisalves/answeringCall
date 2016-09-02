package com.wtech.answeringcall;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class AdminActivity extends AppCompatActivity {
    private Button btLiberar;
    private Button btAtualizar;
    private Button btSair;

    private TextView txtData;
    private TextView txtHora;

    private String data;
    private String hora;

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        dataHoraAtual();

        btLiberar = (Button) findViewById(R.id.btnLiberar);
        btLiberar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                intent = new Intent(AdminActivity.this,ResultAdminActivity.class);
                startActivity(intent);
                finish();
                /**
                 * Aqui eu preciso de mandar para todos participantes a hora de saida
                 */
            }
        });

        btAtualizar = (Button) findViewById(R.id.btnAtualizar);
        btAtualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplication(), "Data e Hora atualizadas!",Toast.LENGTH_SHORT).show();
                intent = new Intent(AdminActivity.this,AdminActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btSair = (Button) findViewById(R.id.btnSair);
        btSair.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplication(), "Saindo do sistema", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }

    public void dataHoraAtual() {
        Date dataAux = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(dataAux);

        DateFormat dataFormat = DateFormat.getDateInstance(DateFormat.SHORT);

        long h = c.get(Calendar.HOUR_OF_DAY);
        long m = c.get(Calendar.MINUTE);
        long s = c.get(Calendar.SECOND);

        String hs = String.valueOf(h);
        String ms = String.valueOf(m);
        String ss = String.valueOf(s);

        data = dataFormat.format(c.getTime());
        hora = "" + hs + ":"+ms+":"+ss;

        txtData = (TextView) findViewById(R.id.txtViewData);
        txtHora = (TextView) findViewById(R.id.txtViewHora);

        txtData.setText(data);
        txtHora.setText(hora);
    }
}