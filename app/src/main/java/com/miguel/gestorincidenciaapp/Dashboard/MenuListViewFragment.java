package com.miguel.gestorincidenciaapp.Dashboard;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.alexvasilkov.events.Events;
import com.miguel.gestorincidenciaapp.AddIssueMedia.AddIssueWithFoto;
import com.miguel.gestorincidenciaapp.DetailedIssue.DetailedIssue;
import com.miguel.gestorincidenciaapp.ViewIssues.DetailIssue;
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
        FloatingActionButton fab = view.findViewById(R.id.fab_addIssue);
        fab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder1 = new AlertDialog.Builder(getContext());
                builder1.setMessage("Com vols obrir la incicencia");
                builder1.setCancelable(true);

                builder1.setPositiveButton(
                        "Formulari",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                                Intent formulari = new Intent(getContext(), DetailedIssue.class);
                                formulari.putExtra("inputEnabled", true);
                                formulari.putExtra("session", session_token);
                                startActivity(formulari);
                            }
                        });

                builder1.setNegativeButton(
                        "Codi QR",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                                Intent qr = new Intent(getContext(), AddIssueWithFoto.class);
                                startActivity(qr);

                            }
                        });

                AlertDialog alert11 = builder1.create();
                alert11.show();
            }
        });

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

        ArrayList<TicketJsonBuilder> closedArray = new ArrayList<>();
        ArrayList<TicketJsonBuilder> openedArray = new ArrayList<>();
        ArrayList<TicketJsonBuilder> pendingArray = new ArrayList<>();

        int closedCont = 0;
        int openedCont = 0;
        int pendingCont = 0;

        for (TicketJsonBuilder closed : data) {

            if(closed.getStatus() == 6){

                closedArray.add(closed);
                closedCont++;
            }

            if(closed.getStatus() == 2){

                openedArray.add(closed);
                openedCont++;
            }

            if (closed.getStatus() == 0){

                pendingArray.add(closed);
                pendingCont++;
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

        menu.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getContext(), DetailIssue.class);

                switch (i){
                    case 0:

                        intent.putExtra("issues", openedArray);
                        startActivity(intent);

                        break;
                    case 1:
                        intent.putExtra("issues", closedArray);
                        startActivity(intent);

                        break;
                    case 3:

                        intent.putExtra("issues", pendingArray);
                        startActivity(intent);

                        break;
                }
            }
        });

    }

}
