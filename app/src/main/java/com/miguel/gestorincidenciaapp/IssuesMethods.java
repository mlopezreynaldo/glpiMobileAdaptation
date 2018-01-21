package com.miguel.gestorincidenciaapp;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

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
    private int closedIssuesD;

    public IssuesMethods(Retrofit retrofit, Context context, String apptoken, String sessionToken) {
        this.apptoken = apptoken;
        this.retrofit = retrofit;
        this.sessionToken = sessionToken;
        this.context = context;
    }


    private void getAllIssues() {

        glpi = retrofit.create(GlpiClient.class);
        Call<List<TicketJsonBuilder>> call = glpi.getAllIssues(apptoken, sessionToken);

        call.enqueue(new Callback<List<TicketJsonBuilder>>() {

            @Override
            public void onResponse(Call<List<TicketJsonBuilder>> call, Response<List<TicketJsonBuilder>> response) {

                if (response.isSuccessful()) {

                    IssuesMethods.this.dataTicket = (ArrayList<TicketJsonBuilder>) response.body();
                    Log.d("DATA TO SEND","DATA" + closedIssuesD);
                }
            }

            @Override
            public void onFailure(Call<List<TicketJsonBuilder>> call, Throwable t) {
            }

        });
    }

    private int getClosedIssues(ArrayList<TicketJsonBuilder> dataCount) {

        int da = 10;

        Log.d("DATA TO SEND","DATA" + da);

        return da;
    }

    public int countClosedIssues(){

        getAllIssues();
        Log.d("DATA TO SEND 1","DATA" + closedIssuesD);

        return closedIssuesD;

    }

}
