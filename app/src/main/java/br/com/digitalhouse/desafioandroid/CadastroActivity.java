package br.com.digitalhouse.desafioandroid;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

public class CadastroActivity extends AppCompatActivity {

    private Button btnregister;
    private TextInputLayout inputNameCadastro;
    private TextInputLayout inputEmailCadastro;
    private TextInputLayout inputSenhaCadastro;
    private TextInputLayout inputRepeteSenhaCadastro;


    public static final String NOME_KEY = "nome";
    public static final String EMAIL_KEY = "email";
    public static final String SENHA_KEY = "password";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        initViews();

        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validaDados();
            }
        });


    }


    private void validaDados() {
        String nome = inputNameCadastro.getEditText().getText().toString();
        String email = inputEmailCadastro.getEditText().getText().toString();
        String senha = inputSenhaCadastro.getEditText().getText().toString();
        String repeteSenha = inputRepeteSenhaCadastro.getEditText().getText().toString();

        if (nome.isEmpty())  {
            inputNameCadastro.setError("Digite o nome!");

        } if (email.isEmpty()) {
            inputEmailCadastro.setError("Digite um email valido");

        } if(senha.isEmpty()){
            inputSenhaCadastro.setError("Digite uma Senha");

        } if (!senha.equals(repeteSenha)) {
            inputRepeteSenhaCadastro.setError("As senhas não batem");

        }else{
            enviaNomeActivity(nome,email,senha);
        }

    }

    private void initViews() {
        btnregister = findViewById(R.id.btnRegisterCadastro);
        inputNameCadastro = findViewById(R.id.inputLayoutTextNomeCadastro);
        inputEmailCadastro = findViewById(R.id.inputLayoutTextEmailCadastro);
        inputSenhaCadastro = findViewById(R.id.inputLayoutTextSenhaCadastro);
        inputRepeteSenhaCadastro = findViewById(R.id.inputLayoutTextRepeteSenhaCadastro);
    }



    private void enviaNomeActivity(String nome,String email,String senha){
        Intent intent = new Intent(CadastroActivity.this, LoginActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString(NOME_KEY, nome);
        bundle.putString(EMAIL_KEY, email);
        bundle.putString(SENHA_KEY, senha);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
