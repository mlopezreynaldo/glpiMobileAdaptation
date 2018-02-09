package com.miguel.gestorincidenciaapp.DetailedIssue;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.miguel.gestorincidenciaapp.R;
import com.miguel.gestorincidenciaapp.POJO.TicketJsonBuilder;

/**
 * A placeholder fragment containing a simple view.
 */
public class DetailedIssueFragment extends Fragment {

    private TicketJsonBuilder object;
    private TextInputEditText title;
    private TextInputEditText date;
    private TextInputEditText status;
    private TextInputEditText urgency;
    private TextInputEditText priority;
    private TextInputEditText description;


    public DetailedIssueFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_detailed_issue, container, false);

        title = inflate.findViewById(R.id.txtTitleIssue);
        date = inflate.findViewById(R.id.dateIssue);
        status = inflate.findViewById(R.id.status);
        urgency = inflate.findViewById(R.id.txtUrgency);
        priority = inflate.findViewById(R.id.txtPriority);
        description = inflate.findViewById(R.id.description);

        Intent i = getActivity().getIntent();
        if(i != null) {

            object = (TicketJsonBuilder) i.getSerializableExtra("issueSelected");

            Log.d("DATA GETTED",object.toti());

            title.setText(object.getName());
            date.setText(object.getDate());

            status.setText(String.valueOf(object.getStatus()));
            urgency.setText(String.valueOf(object.getUrgency()));
            priority.setText(String.valueOf(object.getPriority()));

            description.setText(object.getContent());

            Log.d("DATA GETTED",object.toti());
        }

        return inflate;
    }
}
