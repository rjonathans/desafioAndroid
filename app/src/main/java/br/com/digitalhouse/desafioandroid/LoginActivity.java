package br.com.digitalhouse.desafioandroid;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

import static br.com.digitalhouse.desafioandroid.CadastroActivity.EMAIL_KEY;
import static br.com.digitalhouse.desafioandroid.CadastroActivity.SENHA_KEY;

public class LoginActivity extends AppCompatActivity {

    private Button btnLogin;
    private Button btnRegister;
    private TextInputLayout textInputLayoutEmail;
    private TextInputLayout textInputLayoutSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initViews();



        btnLogin.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View view) {

                String emailDigitado = textInputLayoutEmail.getEditText().getText().toString();
                String senhaDigitada = textInputLayoutSenha.getEditText().getText().toString();

                recebeBundleEValida(emailDigitado,senhaDigitada);

            }


        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,CadastroActivity.class));
            }
        });


    }


    private void recebeBundleEValida(String emailDigitado,String senhaDigitada) {
        String email = "";
        String password = "";
        if (getIntent() != null && getIntent().getExtras() != null) {
            Bundle bundle = getIntent().getExtras();
            email = bundle.getString(EMAIL_KEY);
            password = bundle.getString(SENHA_KEY);

            assert password != null;
            assert email != null;
            if (email.equals(emailDigitado) &&
                    (password.equals(senhaDigitada))) {

                startActivity(new Intent(LoginActivity.this, HomeActivity.class));
            } else {
                alert("Login ou senha incorretos");
            }
        }
    }



    private String validaDado(String dadoRecebido, String dadoDigitado) {
        if (!dadoDigitado.equals(dadoRecebido)) {

        }
        return dadoDigitado;
    }

    private void alert(String frase) {
        Toast.makeText(this, frase, Toast.LENGTH_LONG).show();
    }

    private void initViews() {
        btnLogin = findViewById(R.id.btnLogin);
        btnRegister = findViewById(R.id.btn_register);
        textInputLayoutEmail = findViewById(R.id.textInputLayoutEmail);
        textInputLayoutSenha = findViewById(R.id.textInputLayoutSenha);
    }
}
