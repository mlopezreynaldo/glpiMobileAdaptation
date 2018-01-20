package com.miguel.gestorincidenciaapp;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A placeholder fragment containing a simple view.
 */
public class MenuListViewFragment extends Fragment {

    private ArrayList<String> items;
    private ArrayAdapter<String> adapter;
    private Retrofit retrofit;
    private String app_token = "5o9yiRFgOUlOVYxZLnF1taKj67lnW4bSDUXGUlAj";
    private String session_token = "pv5svvq266ibi82gfioh6dqh21";


    private GlpiClient glpi;
    private TokenInfo data;
    private ArrayList<TicketJsonBuilder> dataTicket;
    private Context context;
    private int closedIssues = 25;

    public MenuListViewFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu_list_view, container, false);

        ListView menu = view.findViewById(R.id.menuApp);

        Retrofit.Builder builder = new Retrofit
                .Builder()
                .baseUrl("http://5.145.175.176/glpi/apirest.php/")
                .addConverterFactory(GsonConverterFactory.create());

        retrofit = builder.build();


//        final IssuesMethods issues = new IssuesMethods(retrofit, getContext(), app_token, session_token);
        getAllIssues();
        String  show = "Incidencies Tancades   " + String.valueOf(closedIssues);

        Log.d("ADAPTER", show);
        String[] data = {
                "Incidencies Obertes" ,
                show,
                "Incidencies Pendents"
        };

        items = new ArrayList<>(Arrays.asList(data));

        adapter = new ArrayAdapter<>(
                getContext(),
                R.layout.menu_app_layout,
                R.id.tituloMenu,
                items
        );

        menu.setAdapter(adapter);
        return view;
    }


    private void getAllIssues() {

        glpi = retrofit.create(GlpiClient.class);
        Call<List<TicketJsonBuilder>> call = glpi.getAllIssues(app_token, session_token);

        call.enqueue(new Callback<List<TicketJsonBuilder>>() {
            @Override
            public void onResponse(Call<List<TicketJsonBuilder>> call, Response<List<TicketJsonBuilder>> response) {

                Log.d("DATA TO ITERATE", response.headers().toString());
                Log.d("DATA TO ITERATE", "WIP :" + response.isSuccessful());

                if (response.isSuccessful()) {

                    closedIssues = 12;
//                    dataTicket = (ArrayList<TicketJsonBuilder>) response.body();
//                    getClosedIssues(dataTicket);

                }
            }
            @Override
            public void onFailure(Call<List<TicketJsonBuilder>> call, Throwable t) {
            }
        });

    }

    private void getClosedIssues(ArrayList<TicketJsonBuilder> dataClosed) {

        for (TicketJsonBuilder json : dataClosed) {
            Log.d("QUE PASA ", "       " + closedIssues);
//            if(json.getStatus() == 2){
                closedIssues++;
//            }
        }
    }

    public int countClosedIssues(){

        getAllIssues();

        return closedIssues;
    }




}
