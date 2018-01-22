package com.miguel.gestorincidenciaapp;

import android.content.Context;
import android.util.Log;
import android.widget.ArrayAdapter;

import com.alexvasilkov.events.Events;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class IssuesMethods {

    private String apptoken;
    private Retrofit retrofit;
    private GlpiClient glpi;
    private TokenInfo data;
    private String sessionToken;
    private ArrayList<TicketJsonBuilder> dataTicket;
    private Context context;

    public IssuesMethods(Retrofit retrofit, Context context, String apptoken, String sessionToken) {
        this.apptoken = apptoken;
        this.retrofit = retrofit;
        this.sessionToken = sessionToken;
        this.context = context;
    }


    @Events.Subscribe("")
    private void pepe(){

    }

    public void closedIssues(ArrayAdapter<String> arrayAdapter) {

        glpi = retrofit.create(GlpiClient.class);
        Call<List<TicketJsonBuilder>> call = glpi.getAllIssues(apptoken, sessionToken);

        call.enqueue(new Callback<List<TicketJsonBuilder>>() {

            @Override
            public void onResponse(Call<List<TicketJsonBuilder>> call, Response<List<TicketJsonBuilder>> response) {

                if (response.isSuccessful()) {

                    dataTicket = (ArrayList<TicketJsonBuilder>) response.body();

                } else {
                    ResponseBody error = response.errorBody();
                    Log.e("XXX", error.toString());
                }
            }

            @Override
            public void onFailure(Call<List<TicketJsonBuilder>> call, Throwable t) {
            }

        });
    }
}
