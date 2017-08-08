package com.example.justgo;


import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.justgo.LogineCadastro.LoginRequest;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText emailEditText = (EditText) findViewById(R.id.emailLogin);
        final EditText senhaEditText = (EditText) findViewById(R.id.senhaLogin);
        final Button bLogin = (Button) findViewById(R.id.email_sign_in_buttonLogin);

        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email= emailEditText.getText().toString();
                final String senha = senhaEditText.getText().toString();

                // Response received from the server
                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");

                            if (success) {
                                String email = jsonResponse.getString("emailResposta");
                                String senha = jsonResponse.getString("senhaResposta");
                                Log.v("Email",email);
                                Log.v("Senha",senha);
                                if(email.contentEquals(email) && senha.contentEquals(senha)) {
                                    AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                                    builder.setMessage("Logado")
                                            .setNegativeButton("TentarNovamente", null)
                                            .create()
                                            .show();
                                }
                            } else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                                builder.setMessage("Não foi possível efetuar o Login")
                                        .setNegativeButton("Tentar Novamente", null)
                                        .create()
                                        .show();
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                LoginRequest loginRequest = new LoginRequest(email, senha, responseListener);
                RequestQueue queue = Volley.newRequestQueue(LoginActivity.this);
                queue.add(loginRequest);
            }
        });
    }
}