package com.miguel.gestorincidenciaapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

public class DetailsIssuesAdapter extends ArrayAdapter<TicketJsonBuilder>{

    private TicketJsonBuilder ticketJsonBuilder;

    public DetailsIssuesAdapter(@NonNull Context context, int resource, List<TicketJsonBuilder> objects) {
        super(context, resource,objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        ticketJsonBuilder = getItem(position);

        if(convertView == null){

            LayoutInflater layoutInflater = LayoutInflater.from(getContext());

        }


        return super.getView(position, convertView, parent);
    }
}
