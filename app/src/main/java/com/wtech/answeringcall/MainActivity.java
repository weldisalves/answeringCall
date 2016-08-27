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

public class MainActivity extends Activity implements View.OnClickListener {
    private EditText edLogin;
    private EditText edSenha;
    private Resources resources;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

        edLogin = (EditText) findViewById(R.id.edtLogin);
        edLogin.addTextChangedListener(textWatcher);
        edSenha = (EditText) findViewById(R.id.edtSenha);
        edSenha.addTextChangedListener(textWatcher);

        Button btnEnter = (Button) findViewById(R.id.btLogin);
        btnEnter.setOnClickListener(this);
    }

    /**
     * Chama o método para limpar erros
     *
     * @param s Editable
     */
    private void callClearErrors(Editable s) {
        if (!s.toString().isEmpty()) {
            clearErrorFields(edLogin);
        }
    }

    @Override
    public void onClick(View v) {
        String login = edLogin.getText().toString();
        String senha = edSenha.getText().toString();
        if (v.getId() == R.id.btLogin) {
            if (validateFields()) {
                /**
                 * Nesse ponto você poderia chamar um serviço de autenticação do usuário.
                 * Por questões de simplicidade e entendimento emitiremos somente um alerta
                 */
                if (login.equals("admin") && senha.equals("123456")) {
                    Intent intent = new Intent(this, AdminActivity.class);
                    startActivity(intent);
                    finish();
                    //Toast.makeText(this, resources.getString(R.string.bem_vindo_adm), Toast.LENGTH_LONG).show();

                } else if(login.equals("weldis") && senha.equals("999999")){
                    Intent intent = new Intent(this, RegisterActivity.class);
                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(this, resources.getString(R.string.login_not_ok), Toast.LENGTH_LONG).show();
                }
            }
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
        String user = edLogin.getText().toString().trim();
        String pass = edSenha.getText().toString().trim();
        return (!isEmptyFields(user, pass) && hasSizeValid(user, pass));
    }

    private boolean isEmptyFields(String user, String pass) {
        if (TextUtils.isEmpty(user)) {
            edLogin.requestFocus(); //seta o foco para o campo user
            edLogin.setError(resources.getString(R.string.login_user_required));
            return true;
        } else if (TextUtils.isEmpty(pass)) {
            edSenha.requestFocus(); //seta o foco para o campo password
            edSenha.setError(resources.getString(R.string.login_password_required));
            return true;
        }
        return false;
    }

    private boolean hasSizeValid(String user, String pass) {
        if (!(user.length() > 3)) {
            edLogin.requestFocus();
            edLogin.setError(resources.getString(R.string.login_user_size_invalid));
            return false;
        } else if (!(pass.length() > 5)) {
            edSenha.requestFocus();
            edSenha.setError(resources.getString(R.string.login_pass_size_invalid));
            return false;
        }
        return true;
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