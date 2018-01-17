package com.miguel.gestorincidenciaapp;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class IssuesMethods {

    private String apptoken = "5o9yiRFgOUlOVYxZLnF1taKj67lnW4bSDUXGUlAj";
    private Retrofit retrofit;
    private GlpiClient glpi;
    private TokenInfo data;
    private String sessionToken;
    private ArrayList<TicketJsonBuilder> dataTicket;
    private Context context;
    private int closedIssues;

    public int getClosedIssues() {
        return closedIssues;
    }

    public void setClosedIssues(int closedIssues) {
        this.closedIssues = closedIssues;
    }

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

        for (TicketJsonBuilder json : dataClosed) {
            if(json.getStatus() == 2){
                closedIssues++;
            }
        }
        setClosedIssues(closedIssues);
        Log.d("CHECK", "         " + closedIssues);
    }

    public int countClosedIssues(){
        getAllIssues();
        Log.d("DEEEEEEEBUG", "    " + getClosedIssues());
        return closedIssues;
    }

}
