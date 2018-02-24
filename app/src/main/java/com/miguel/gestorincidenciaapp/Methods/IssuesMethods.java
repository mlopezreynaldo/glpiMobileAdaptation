package com.miguel.gestorincidenciaapp.Methods;

import android.util.Log;

import com.alexvasilkov.events.Events;
import com.miguel.gestorincidenciaapp.APInterface.GlpiClient;
import com.miguel.gestorincidenciaapp.POJO.TicketJsonBuilder;
import com.miguel.gestorincidenciaapp.POJO.TokenInfo;

import java.util.ArrayList;
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

    public IssuesMethods(Retrofit retrofit, String apptoken, String sessionToken) {
        this.apptoken = apptoken;
        this.retrofit = retrofit;
        this.sessionToken = sessionToken;
    }


    public void allIssues() {

        glpi = retrofit.create(GlpiClient.class);
        Call<List<TicketJsonBuilder>> call = glpi.getAllIssues(apptoken, sessionToken);

        call.enqueue(new Callback<List<TicketJsonBuilder>>() {

            @Override
            public void onResponse(Call<List<TicketJsonBuilder>> call, Response<List<TicketJsonBuilder>> response) {

                if (response.isSuccessful()) {

                    dataTicket = (ArrayList<TicketJsonBuilder>) response.body();
                    Events.create("closed").param(dataTicket).post();

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
