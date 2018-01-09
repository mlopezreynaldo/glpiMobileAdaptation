package com.miguel.gestorincidenciaapp;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Login extends AppCompatActivity {

    private String apptoken = "5o9yiRFgOUlOVYxZLnF1taKj67lnW4bSDUXGUlAj";
    private Retrofit retrofit;
    private GlpiClient glpi;
    private TokenInfo data;
    private String sessionToken;

    public Login() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        Button login = findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                login();

            }
        });

    }

    private void login() {
        glpi = retrofit.create(GlpiClient.class);
        Call<TokenInfo> call = glpi.initSession("glpi", "D1A2I3", apptoken);
        call.enqueue(new Callback<TokenInfo>() {

            @Override
            public void onResponse(Call<TokenInfo> call, Response<TokenInfo> response) {

                if(response.isSuccessful()){

                    data = response.body();
                    Log.d("InitSessionResponse", response.toString());

                    Log.d("InitSessionResponse", response.body().toString());

                    getFullSession(call, response.body().getSessionToken());


                } else {

                    ResponseBody body = response.errorBody();
                    Log.d("ERROR", body.toString());

                    try {

                        Toast.makeText(Login.this, "ERROR" + body.string(), Toast.LENGTH_LONG).show();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<TokenInfo> call, Throwable t) {}
        });
    }
    private void getFullSession(Call<TokenInfo> call, final String sessionToken1) {
        call = null;
        call = glpi.getFullSession( sessionToken1 , apptoken);
        call.enqueue(new Callback<TokenInfo>() {
            @Override
            public void onResponse(Call<TokenInfo> call, Response<TokenInfo> response) {

                Log.d("URL", call.request().url().toString());

                if(response.isSuccessful()){

                    data = response.body();
                    Log.d("DATA", "DATA" + " Funciona el full session");

                    Toast.makeText(Login.this,"DATA" + sessionToken1, Toast.LENGTH_LONG).show();

                } else {

                    ResponseBody body = response.errorBody();
                    Log.d("ERROR", body.toString());

                    try {

                        Toast.makeText(Login.this, "ERROR" + body.string(), Toast.LENGTH_LONG).show();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                sessionToken = sessionToken1;

            }

            @Override
            public void onFailure(Call<TokenInfo> call, Throwable t) {

                Context context = Login.this;
                Toast.makeText(context, t.getMessage(), Toast.LENGTH_LONG).show();

            }
        });
    }

}
