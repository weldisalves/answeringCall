package com.wtech.answeringcall;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends Activity {
    private EditText edId;
    private Button bSaiu;
    private Button bEntrou;
    private Resources resources;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initViews();
    }

    /**
     * Recupera as views e configura os listeners para os campos editáveis e para o botão de entrar
     */
    private void initViews() {
        resources = getResources();
        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                callClearErrors(s);
            }
        };

        edId = (EditText) findViewById(R.id.edtId);
        edId.addTextChangedListener(textWatcher);

        bSaiu = (Button) findViewById(R.id.btSaiu);
        bEntrou = (Button) findViewById(R.id.btSaiu);

        bSaiu.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String id = edId.getText().toString();

                if (v.getId() == R.id.btSaiu) {
                    if (validateFields()) {
                        /**
                         * Nesse ponto você poderia chamar um serviço de autenticação do usuário.
                         * Por questões de simplicidade e entendimento emitiremos somente um alerta
                         */
                        if (id.equals("123")) {
                            Intent troca = new Intent(RegisterActivity.this, ResultActivity.class);
                            RegisterActivity.this.startActivity(troca);
                            RegisterActivity.this.finish();
                        } else {
                            Toast.makeText(RegisterActivity.this, resources.getString(R.string.id_found), Toast.LENGTH_LONG).show();
                        }
                    }
                }
            }
        });

        bEntrou.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String id = edId.getText().toString();

                if (v.getId() == R.id.btEntrou) {
                    if (validateFields()) {
                        /**
                         * Nesse ponto a existencia do participante na base de dados

                         */
                        if (id.equals("123")) {
                            Intent troca = new Intent(RegisterActivity.this, ResultActivity.class);
                            RegisterActivity.this.startActivity(troca);
                            RegisterActivity.this.finish();
                        } else {
                            Toast.makeText(RegisterActivity.this, resources.getString(R.string.id_found), Toast.LENGTH_LONG).show();
                        }
                    }
                }

            }
        });
    }


    /**
     * Chama o método para limpar erros
     *
     * @param s Editable
     */
    private void callClearErrors(Editable s) {
        if (!s.toString().isEmpty()) {
            clearErrorFields(edId);
        }
    }

    /**
     * Efetua a validação dos campos.Nesse caso, valida se os campos não estão vazios e se tem
     * tamanho permitido.
     * Nesse método você poderia colocar outros tipos de validações de acordo com a sua necessidade.
     *
     * @return boolean que indica se os campos foram validados com sucesso ou não
     */
    private boolean validateFields() {
        String id = edId.getText().toString().trim();
        return (!isEmptyFields(id));
    }

    private boolean isEmptyFields(String id) {
        if (TextUtils.isEmpty(id)) {
            edId.requestFocus(); //seta o foco para o campo id
            edId.setError(resources.getString(R.string.id_required));
            return true;
        }
        return false;
    }

    /**
     * Limpa os ícones e as mensagens de erro dos campos desejados
     *
     * @param editTexts lista de campos do tipo EditText
     */
    private void clearErrorFields(EditText... editTexts) {
        for (EditText editText : editTexts) {
            editText.setError(null);
        }
    }
}