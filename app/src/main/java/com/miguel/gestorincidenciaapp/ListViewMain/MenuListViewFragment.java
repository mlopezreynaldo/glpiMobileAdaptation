package com.miguel.gestorincidenciaapp.ListViewMain;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.alexvasilkov.events.Events;
import com.miguel.gestorincidenciaapp.ListViewIssues.DetailIssue;
import com.miguel.gestorincidenciaapp.Methods.IssuesMethods;
import com.miguel.gestorincidenciaapp.R;
import com.miguel.gestorincidenciaapp.POJO.TicketJsonBuilder;

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
    private ArrayList<TicketJsonBuilder> dataSendList;
    private Retrofit retrofit;
    private String app_token = "5o9yiRFgOUlOVYxZLnF1taKj67lnW4bSDUXGUlAj";
    private String session_token;
    private ListView menu;

    public MenuListViewFragment() {}

    @Override
    public void onStart() {
        super.onStart();

        Events.register(this);
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu_list_view, container, false);

        Intent getSession = getActivity().getIntent();
        session_token = (String) getSession.getSerializableExtra("session_token");

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
        menu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                String jsonBuilder = (String) adapterView.getItemAtPosition(i);
                Intent intent = new Intent(getContext(), DetailIssue.class);
                intent.putExtra("issues", dataSendList);
                startActivity(intent);

            }
        });

        IssuesMethods issues = new IssuesMethods(retrofit,app_token,session_token);
        issues.allIssues();

        return view;
    }

    @Events.Subscribe("closed")
    private void onClosedIssues(ArrayList<TicketJsonBuilder> data){

        dataSendList = data;

        Log.d("DATA GETTED",data.toString());

        int closedCont = 0;
        int openedCont = 0;
        int pendingCont = 0;

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
                "Incidencies Pendents   " + pendingCont
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
