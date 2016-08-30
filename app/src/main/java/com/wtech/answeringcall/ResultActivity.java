package com.wtech.answeringcall;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class ResultActivity extends AppCompatActivity {
    private Button btProximo;

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        btProximo = (Button) findViewById(R.id.btnProximo);
        btProximo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                intent = new Intent(ResultActivity.this,RegisterActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}