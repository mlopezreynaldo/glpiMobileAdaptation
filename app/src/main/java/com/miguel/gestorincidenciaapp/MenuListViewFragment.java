package com.miguel.gestorincidenciaapp;

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
    private String session_token = "6l9gsspc3v41todh6qdnib0e85";

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


        IssuesMethods issues = new IssuesMethods(retrofit, getContext(), app_token, session_token);
        issues.countClosedIssues();

        Log.d("ISSUESCOUNT","   " + issues.countClosedIssues());


        String[] data = {
                "Incidencies Obertes" ,
                "Incidencies Tancades   " + issues.getClosedIssues(),
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




}
