package com.miguel.gestorincidenciaapp;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.alexvasilkov.events.Events;

import java.util.ArrayList;
import java.util.Arrays;

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
    private String session_token = "pp8mg4vdbnbvm9og9hff9etud4";
    private ListView menu;

    public MenuListViewFragment() {}

    @Override
    public void onStart() {
        super.onStart();

        Events.register(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_menu_list_view, container, false);

        Log.d("SHOW TOKEN",session_token);

        menu = view.findViewById(R.id.menuApp);

        Retrofit.Builder builder = new Retrofit
                .Builder()
                .baseUrl("http://5.145.175.176/glpi/apirest.php/")
                .addConverterFactory(GsonConverterFactory.create());

        retrofit = builder.build();

        String[] data = {
                "Incidencies Obertes" ,
                "Incidencies Tancades",
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
        IssuesMethods issues = new IssuesMethods(retrofit,app_token,session_token);
        issues.allIssues();

        return view;
    }

    @Events.Subscribe("closed")
    private void onClosedIssues(ArrayList<TicketJsonBuilder> data){

        int closedCont = 0;
        int openedCont = 0;

        for (TicketJsonBuilder closed : data) {

            if(closed.getStatus() == 6){
                closedCont++;

            }

            if(closed.getStatus() == 2){
                openedCont++;
            }

        }

        String[] dataS = {
                "Incidencies Obertes    "  + openedCont,
                "Incidencies Tancades   " + closedCont,
                "Incidencies Pendents"
        };

        items = new ArrayList<>(Arrays.asList(dataS));

        adapter = new ArrayAdapter<>(
                getContext(),
                R.layout.menu_app_layout,
                R.id.tituloMenu,
                items
        );

        menu.setAdapter(adapter);

    }
}
