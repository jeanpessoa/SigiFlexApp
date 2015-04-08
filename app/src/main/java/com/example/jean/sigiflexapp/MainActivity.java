package com.example.jean.sigiflexapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends Activity {

    Boolean serverStatus = true;
    String nomeValido = "admin", senhaValida = "admin";
    Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tvName = (TextView) findViewById(R.id.loginTvName);
        TextView tvPassword = (TextView) findViewById(R.id.loginTvPassword);
        //TextView ver = (TextView) = findViewById(R.id.version);
        final EditText etName = (EditText) findViewById(R.id.loginEdName);
        final EditText etPassword = (EditText) findViewById(R.id.loginEdPassword);
        Button btNext = (Button) findViewById(R.id.loginBtNext);

        //ver.setText(context.getApplicationInfo().toString());

        //strings representando textos recebidos do servidor

        String name = "Nome:", password = "Senha:", hintName = "Digite seu nome de usuário!", hintPassword = "Digite sua senha!", button = "Logar";


        tvName.setText(name);
        tvPassword.setText(password);
        etName.setHint(hintName);
        etPassword.setHint(hintPassword);
        btNext.setText(button);

        btNext.setOnClickListener(new View.OnClickListener() {
            Context context = getApplicationContext();
            @Override
            public void onClick(View v) {
                if (etName.getText().toString() == nomeValido && etPassword.getText().toString()== senhaValida)
                    new AlertDialog.Builder(context).setTitle("Resposta do servidor:").setMessage("Nome ou senha invalidos. Por favor tente novamente.");
                else
                    new AlertDialog.Builder(context).setTitle("Resposta do servidor:").setMessage("Login efetuado com sucesso.");
            }
        });


    }

    private String conectionStatus (){
        if (serverStatus!= true)
            return "Serviço indisponivel no momento!";
        else
            return "Serviço disponível!";
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
