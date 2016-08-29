package com.wtech.answeringcall;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btLogin;
    private EditText edLogin;
    private EditText edSenha;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btLogin = (Button) findViewById(R.id.btnLogin);
        edLogin = (EditText) findViewById(R.id.edtLogin);
        edSenha = (EditText) findViewById(R.id.edtSenha);

        btLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String login = edLogin.getText().toString();
                String senha = edSenha.getText().toString();
                if(login.length() == 0 || senha.length() == 0){
                    Toast.makeText(getApplication(), "Os campos login e senha são obrigatórios!",Toast.LENGTH_LONG).show();
                }else if(login.equals("admin") && senha.equals("123")){
                    intent = new Intent(MainActivity.this,AdminActivity.class);
                    startActivity(intent);
                    finish();
                    Toast.makeText(getApplication(), "Seja bem vindo " + login.toUpperCase() + "!",Toast.LENGTH_LONG).show();
                }else if(login.equals("weldis") && senha.equals("123")) {
                    intent = new Intent(MainActivity.this,RegisterActivity.class);
                    startActivity(intent);
                    finish();
                    Toast.makeText(getApplication(), "Seja bem vindo " + login.toUpperCase() + "!", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getApplication(), "Login não autorizado!!",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}