package com.miguel.gestorincidenciaapp;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A placeholder fragment containing a simple view.
 */
public class DetailIssueFragment extends Fragment {

    public DetailIssueFragment() {
    }

    private ArrayList<TicketJsonBuilder> items;
    private ArrayAdapter<TicketJsonBuilder> adapter;
    private ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_detail_issue, container, false);

        Intent i = getActivity().getIntent();
        listView = inflate.findViewById(R.id.details);

        if(i != null){

            ArrayList<TicketJsonBuilder> jsonBuilder = (ArrayList<TicketJsonBuilder>) i.getSerializableExtra("issues");

            if(jsonBuilder != null){

                items = new ArrayList<>();
                items = jsonBuilder;

                adapter = new ArrayAdapter<TicketJsonBuilder>(
                        getContext(),
                        R.layout.fragment_detail_issue,
                        R.id.tituloMenu,
                        items
                );

                listView.setAdapter(adapter);

                Log.d("DATA JSON",jsonBuilder.get(1).getName());
                Log.d("DATA", "DATA IS IRIGHYT");
            }
        }

        return inflate;
    }
}
