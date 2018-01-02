package com.miguel.gestorincidenciaapp;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

        Button login = view.findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

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

                                Toast.makeText(getContext(), "ERROR" + body.string(), Toast.LENGTH_LONG).show();

                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<TokenInfo> call, Throwable t) {}
                });
            }

        });


        Button addIssue = view.findViewById(R.id.addIssue);
        addIssue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Date d = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String date = sdf.format(d);

                TicketJsonBuilder t = new TicketJsonBuilder("hola",date,2,"dada",1,1,2);
                Log.d("DEBUG", t.toString());

                Call<TicketJsonBuilder> call = glpi.setNewIssue(apptoken,sessionToken, t);

                call.enqueue(new Callback<TicketJsonBuilder>() {
                    @Override
                    public void onResponse(Call<TicketJsonBuilder> call, Response<TicketJsonBuilder> response) {

                        if(response.isSuccessful()){

                            Log.d("RESPUESTA",response.body().toString());

                        } else {

                            Log.d("RESPUESTA",response.toString() + "   " + response.headers());

                        }
                    }
                    @Override
                    public void onFailure(Call<TicketJsonBuilder> call, Throwable t) {
                    }
                });
            }
        });

        return view;

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

                    Toast.makeText(getContext(),"DATA" + sessionToken1, Toast.LENGTH_LONG).show();

                } else {

                    ResponseBody body = response.errorBody();
                    Log.d("ERROR", body.toString());

                    try {

                        Toast.makeText(getContext(), "ERROR" + body.string(), Toast.LENGTH_LONG).show();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                sessionToken = sessionToken1;

            }

            @Override
            public void onFailure(Call<TokenInfo> call, Throwable t) {

                Context context = getContext();
                Toast.makeText(context, t.getMessage(), Toast.LENGTH_LONG).show();

            }
        });
    }
}
