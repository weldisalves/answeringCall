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

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class RegisterActivity extends AppCompatActivity {
    private Button btSaiu;
    private Button btEntrou;

    private TextView txtHora;
    private TextView txtData;

    private EditText edId;

    private Intent intent;

    private Presenca presenca = new Presenca();
    private Bundle bundle;


    @TargetApi(Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        txtData = (TextView) findViewById(R.id.txtViewData);
        txtHora = (TextView) findViewById(R.id.txtViewHora);

        dataHoraAtual();

        txtData.setText(presenca.getData());
        txtHora.setText(presenca.getHora());

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
                    startActivity(intent);

                    finish();
                }
            }
        });
    }

    public boolean verificar() {
        String id = edId.getText().toString();
        if (id.length() == 0) {
            Toast.makeText(getApplication(), "Campo ID participante obrigatório", Toast.LENGTH_LONG).show();
            return false;
        } else if (!id.equals("123")) {
            Toast.makeText(getApplication(), "ID inválido!!", Toast.LENGTH_LONG).show();
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

        String dataAux = dataFormat.format(c.getTime());
        String horaAux = "" + hs + ":"+ms+":"+ss;

        presenca.setData(dataAux);
        presenca.setHora(horaAux);
    }
}