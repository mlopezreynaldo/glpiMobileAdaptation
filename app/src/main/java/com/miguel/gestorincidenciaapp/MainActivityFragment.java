package com.miguel.gestorincidenciaapp;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private String apptoken = "5o9yiRFgOUlOVYxZLnF1taKj67lnW4bSDUXGUlAj";
    private Retrofit retrofit;
    private GlpiClient glpi;
    private TokenInfo data;
    private String sessionToken;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ListView listView = (ListView) view.findViewById(R.id.list_item_pagination_text);

        Retrofit.Builder builder = new Retrofit
                .Builder()
                .baseUrl("http://5.145.175.176/glpi/apirest.php/")
                .addConverterFactory(GsonConverterFactory.create());

        retrofit = builder.build();

        final Button login = view.findViewById(R.id.login);
//        login.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                login();
//            }
//
//        });

        Button addIssue = view.findViewById(R.id.addIssue);
        addIssue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addIssue();
            }
        });

        Button createUser = view.findViewById(R.id.registrer);
        createUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerUser();
            }
        });

        Button newIntance = view.findViewById(R.id.buttonu);
        newIntance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent in = new Intent(getContext(),Login.class);
                startActivity(in);

            }
        });


        return view;

    }

    private void registerUser() {

        Map<String , RegisterUser> registerUserMap = new HashMap<>();
        final RegisterUser registerUser = new RegisterUser("PAPA","KAKA",13,"SKRAAAH", 666666);
        registerUserMap.put("input",registerUser);

        Call<RegisterUser> call = glpi.registerUser(apptoken,sessionToken,registerUserMap);

        call.enqueue(new Callback<RegisterUser>() {
            @Override
            public void onResponse(Call<RegisterUser> call, Response<RegisterUser> response) {

                if(response.isSuccessful()){

                    Toast.makeText(getContext(),"DATA" + response.headers(), Toast.LENGTH_LONG);

                } else {

                    Toast.makeText(getContext(),"Not WORK", Toast.LENGTH_LONG);

                }

            }

            @Override
            public void onFailure(Call<RegisterUser> call, Throwable t) {

            }
        });

    }

    private void addIssue() {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = sdf.format(d);

        TicketJsonBuilder t = new TicketJsonBuilder("hola",date,2,"dada",1,1,2);
        Log.d("DEBUG", t.toString());

        Map<String, TicketJsonBuilder> map = new HashMap<>();
        map.put("input", t);

        Call<TicketJsonBuilder> call = glpi.setNewIssue(apptoken,sessionToken, map);

        call.enqueue(new Callback<TicketJsonBuilder>() {
            @Override
            public void onResponse(Call<TicketJsonBuilder> call, Response<TicketJsonBuilder> response) {

                if(response.isSuccessful()){

                    Toast.makeText(getContext(),"DATA" + response.headers(), Toast.LENGTH_LONG).show();
                    Log.d("RESPUESTA",response.body().toString());

                } else {

                    Toast.makeText(getContext(),"DATA" + response.isSuccessful(), Toast.LENGTH_LONG).show();
                    Log.d("RESPUESTA",response.toString() + "   " + response.headers());

                }
            }
            @Override
            public void onFailure(Call<TicketJsonBuilder> call, Throwable t) {
            }
        });
    }

//    private void login() {
//        glpi = retrofit.create(GlpiClient.class);
//        Call<TokenInfo> call = glpi.initSession("glpi", "D1A2I3", apptoken);
//        call.enqueue(new Callback<TokenInfo>() {
//
//            @Override
//            public void onResponse(Call<TokenInfo> call, Response<TokenInfo> response) {
//
//                if(response.isSuccessful()){
//
//                   data = response.body();
//                   Log.d("InitSessionResponse", response.toString());
//
//                   Log.d("InitSessionResponse", response.body().toString());
//
//                    getFullSession(call, response.body().getSessionToken());
//
//
//                } else {
//
//                    ResponseBody body = response.errorBody();
//                    Log.d("ERROR", body.toString());
//
//                    try {
//
//                        Toast.makeText(getContext(), "ERROR" + body.string(), Toast.LENGTH_LONG).show();
//
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//
//            @Override
//            public void onFailure(Call<TokenInfo> call, Throwable t) {}
//        });
//    }
//
//    private void getFullSession(Call<TokenInfo> call, final String sessionToken1) {
//        call = null;
//        call = glpi.getFullSession( sessionToken1 , apptoken);
//        call.enqueue(new Callback<TokenInfo>() {
//            @Override
//            public void onResponse(Call<TokenInfo> call, Response<TokenInfo> response) {
//
//                Log.d("URL", call.request().url().toString());
//
//                if(response.isSuccessful()){
//
//                    data = response.body();
//                    Log.d("DATA", "DATA" + " Funciona el full session");
//
//                    Toast.makeText(getContext(),"DATA" + sessionToken1, Toast.LENGTH_LONG).show();
//
//                } else {
//
//                    ResponseBody body = response.errorBody();
//                    Log.d("ERROR", body.toString());
//
//                    try {
//
//                        Toast.makeText(getContext(), "ERROR" + body.string(), Toast.LENGTH_LONG).show();
//
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
//
//                sessionToken = sessionToken1;
//
//            }
//
//            @Override
//            public void onFailure(Call<TokenInfo> call, Throwable t) {
//
//                Context context = getContext();
//                Toast.makeText(context, t.getMessage(), Toast.LENGTH_LONG).show();
//
//            }
//        });
//    }
}
