package com.wtech.answeringcall;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class RegisterActivity extends AppCompatActivity {
    private Button btSaiu;
    private Button btEntrou;
    private Button btSair;

    private TextView txtHora;
    private TextView txtData;

    private EditText edId;

    private Intent intent;

    private String dataAux;
    private String horaAux;

    private Presenca presenca = new Presenca();

    @TargetApi(Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        dataHoraAtual();

        /**
         * iteração dosbotões da tela
         */
        btSaiu = (Button) findViewById(R.id.btnSaiu);
        btEntrou = (Button) findViewById(R.id.btnEntrou);

        edId = (EditText) findViewById(R.id.edtId);

        btSaiu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (verificar()) {
                    presenca.setStatus("saida");

                    intent = new Intent(RegisterActivity.this, CheckInActivity.class);
                    intent.putExtra("presenca",presenca);

                    startActivity(intent);
                    finish();
                }
            }
        });

        btEntrou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (verificar()) {
                    presenca.setStatus("entrada");

                    intent = new Intent(RegisterActivity.this, CheckInActivity.class);
                    intent.putExtra("presenca",presenca);

                    startActivity(intent);
                    finish();
                }
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

    public boolean verificar() {
        String id = edId.getText().toString();
        if (id.length() == 0) {
            Toast.makeText(getApplication(), "Campo ID participante obrigatório", Toast.LENGTH_SHORT).show();
            return false;
        } else if (Integer.parseInt(id) != 123) {
            Toast.makeText(getApplication(), "ID inválido!!", Toast.LENGTH_SHORT).show();
            return false;
        }
        presenca.setIdParticipante(Integer.parseInt(id));
        return true;
    }

    public void dataHoraAtual() {
        Date data = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(data);

        DateFormat dataFormat = DateFormat.getDateInstance(DateFormat.SHORT);

        long h = c.get(Calendar.HOUR_OF_DAY);
        long m = c.get(Calendar.MINUTE);
        long s = c.get(Calendar.SECOND);

        String hs = String.valueOf(h);
        String ms = String.valueOf(m);
        String ss = String.valueOf(s);

        dataAux = dataFormat.format(c.getTime());
        horaAux = "" + hs + ":"+ms+":"+ss;

        presenca.setData(dataAux);
        presenca.setHora(horaAux);

        txtData = (TextView) findViewById(R.id.txtViewData);
        txtHora = (TextView) findViewById(R.id.txtViewHora);

        txtData.setText(presenca.getData());
        txtHora.setText(presenca.getHora());
    }
}