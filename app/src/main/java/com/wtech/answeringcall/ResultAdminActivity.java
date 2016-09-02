package com.wtech.answeringcall;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ResultAdminActivity extends AppCompatActivity {
    private Button btSair;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_admin);

        btSair = (Button) findViewById(R.id.btnSair);
        btSair.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplication(), "Saindo do sistema", Toast.LENGTH_LONG).show();
                finish();
            }
        });
    }
}