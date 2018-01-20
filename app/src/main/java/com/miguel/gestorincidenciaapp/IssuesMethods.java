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


    public int getClosedIssuesD() {
        return closedIssuesD;
    }

    public void setClosedIssuesD(int closedIssuesD) {
        this.closedIssuesD = closedIssuesD;
    }

    private void getAllIssues() {

        glpi = retrofit.create(GlpiClient.class);
        Call<List<TicketJsonBuilder>> call = glpi.getAllIssues(apptoken, sessionToken);

        call.enqueue(new Callback<List<TicketJsonBuilder>>() {

            @Override
            public void onResponse(Call<List<TicketJsonBuilder>> call, Response<List<TicketJsonBuilder>> response) {

                if (response.isSuccessful()) {

                    dataTicket = (ArrayList<TicketJsonBuilder>) response.body();
                    getClosedIssues(dataTicket);
                }
            }

            @Override
            public void onFailure(Call<List<TicketJsonBuilder>> call, Throwable t) {
            }

        });
    }

    private void getClosedIssues(ArrayList<TicketJsonBuilder> dataClosed) {

        int da = 0;

        for (TicketJsonBuilder json : dataClosed) {
            da++;
        }

        setClosedIssuesD(da);

    }

    public int countClosedIssues(){

        getAllIssues();
        return getClosedIssuesD();

    }

}
