package com.wtech.answeringcall;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AdminActivity extends AppCompatActivity {
    private Button btLiberar;
    private Button btAtualizar;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

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
                Toast.makeText(getApplication(), "Data e Hora atualizadas!",Toast.LENGTH_LONG).show();
            }
        });
    }
}