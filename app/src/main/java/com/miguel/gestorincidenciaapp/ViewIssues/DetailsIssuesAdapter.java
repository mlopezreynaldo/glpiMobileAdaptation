package com.miguel.gestorincidenciaapp.ViewIssues;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.miguel.gestorincidenciaapp.POJO.TicketJsonBuilder;
import com.miguel.gestorincidenciaapp.R;

import java.util.List;

public class DetailsIssuesAdapter extends ArrayAdapter<TicketJsonBuilder>{

    public DetailsIssuesAdapter(@NonNull Context context, int resource, @NonNull List<TicketJsonBuilder> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        TicketJsonBuilder ticketJsonBuilder = getItem(position);

        if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.details_app_layout, parent, false);

        }


        TextView title = convertView.findViewById(R.id.titleIssues);
        TextView description = convertView.findViewById(R.id.titleDescriptionLay);

        title.setText(ticketJsonBuilder.getName());
        description.setText(ticketJsonBuilder.getContent());

        return convertView;
    }
}
