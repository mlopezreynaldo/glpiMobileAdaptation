package com.miguel.gestorincidenciaapp.ListViewIssues;

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

import com.hlab.fabrevealmenu.view.FABRevealMenu;
import com.miguel.gestorincidenciaapp.DetailedIssue.DetailedIssue;
import com.miguel.gestorincidenciaapp.R;
import com.miguel.gestorincidenciaapp.POJO.TicketJsonBuilder;

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
    private FABRevealMenu fabMenu;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_detail_issue, container, false);

        Intent i = getActivity().getIntent();

        listView = inflate.findViewById(R.id.details);

        if(i != null){

            ArrayList<TicketJsonBuilder> jsonBuilder = (ArrayList<TicketJsonBuilder>) i.getSerializableExtra("issues");

            if(jsonBuilder != null){

                items = jsonBuilder;

                Log.d("DATA GETTED", jsonBuilder.toString());

                items = new ArrayList<>(items);

                adapter = new DetailsIssuesAdapter(
                        getContext(),
                        R.layout.details_app_layout,
                        items
                );

                listView.setAdapter(adapter);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                        TicketJsonBuilder objectToSend = (TicketJsonBuilder) adapterView.getItemAtPosition(i);
                        Intent intent = new Intent(getContext(), DetailedIssue.class);
                        intent.putExtra("issueSelected", objectToSend);
                        intent.putExtra("inputEnabled", false);
                        startActivity(intent);
                    }
                });
            }
        }
        return inflate;
    }

    public FABRevealMenu getFabMenu() {
        return fabMenu;
    }

    public void setFabMenu(FABRevealMenu fabMenu) {
        this.fabMenu = fabMenu;
    }
}
