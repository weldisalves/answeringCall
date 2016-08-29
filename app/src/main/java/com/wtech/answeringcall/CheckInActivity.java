package com.wtech.answeringcall;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class CheckInActivity extends AppCompatActivity {
    private Button btConfirmar;
    private Button btCancelar;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkin);

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
                intent = new Intent(CheckInActivity.this,ResultActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}