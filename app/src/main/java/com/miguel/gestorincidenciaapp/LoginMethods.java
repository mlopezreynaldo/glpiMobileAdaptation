package com.miguel.gestorincidenciaapp;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class LoginMethods {
    private String apptoken = "5o9yiRFgOUlOVYxZLnF1taKj67lnW4bSDUXGUlAj";
    private Retrofit retrofit;
    private GlpiClient glpi;
    private TokenInfo data;
    private String sessionToken = "s8fp7lrsir84k81om79uvddqi7";
    private Context context;

    public LoginMethods(Retrofit retrofit, Context context) {
        this.retrofit = retrofit;
        this.context = context;
    }

    public String getSessionToken() {
        return sessionToken;
    }

    public void setSessionToken(String sessionToken) {
        this.sessionToken = sessionToken;
    }

    public void login(String username, String password) {
        glpi = retrofit.create(GlpiClient.class);
        Call<TokenInfo> call = glpi.initSession(username, password, apptoken);
        call.enqueue(new Callback<TokenInfo>() {

            @Override
            public void onResponse(Call<TokenInfo> call, Response<TokenInfo> response) {

                if(response.isSuccessful()){

                    data = response.body();
                    getFullSession(call, response.body().getSessionToken());

                } else {

                    ResponseBody body = response.errorBody();
                    Log.d("ERROR", body.toString());

                    try {

                        Toast.makeText(context, "ERROR" + body.string(), Toast.LENGTH_LONG).show();

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

                    Toast.makeText(context,"DATA" + sessionToken1, Toast.LENGTH_LONG).show();

                } else {

                    ResponseBody body = response.errorBody();
                    Log.d("ERROR", body.toString());

                    try {

                        Toast.makeText(context, "ERROR" + body.string(), Toast.LENGTH_LONG).show();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                setSessionToken(sessionToken1);

            }

            @Override
            public void onFailure(Call<TokenInfo> call, Throwable t) {

                Toast.makeText(context, t.getMessage(), Toast.LENGTH_LONG).show();

            }
        });
    }

}
