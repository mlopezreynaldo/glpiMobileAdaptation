package com.miguel.gestorincidenciaapp.DetailedIssue;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.content.res.AppCompatResources;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.Toast;

import com.alexvasilkov.events.Events;
import com.hlab.fabrevealmenu.enums.Direction;
import com.hlab.fabrevealmenu.listeners.OnFABMenuSelectedListener;
import com.hlab.fabrevealmenu.model.FABMenuItem;
import com.hlab.fabrevealmenu.view.FABRevealMenu;
import com.miguel.gestorincidenciaapp.FabBaseFragment;
import com.miguel.gestorincidenciaapp.R;
import com.miguel.gestorincidenciaapp.POJO.TicketJsonBuilder;

import java.util.ArrayList;

/**
 * A placeholder fragment containing a simple view.
 */
public class DetailedIssueFragment extends FabBaseFragment implements OnFABMenuSelectedListener{

    private TicketJsonBuilder object;
    private TextInputEditText title;
    private TextInputEditText date;
    private TextInputEditText status;
    private TextInputEditText urgency;
    private TextInputEditText priority;
    private TextInputEditText description;
    private boolean inputsEnabled;
    private ArrayList<FABMenuItem> items;
    private Direction currentDirection = Direction.UP;


    public DetailedIssueFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_detailed_issue, container, true);

        title = inflate.findViewById(R.id.txtTitleIssue);
        date = inflate.findViewById(R.id.dateIssue);
        status = inflate.findViewById(R.id.status);
        urgency = inflate.findViewById(R.id.txtUrgency);
        priority = inflate.findViewById(R.id.txtPriority);
        description = inflate.findViewById(R.id.description);

        Intent i = getActivity().getIntent();
        inputsEnabled = (boolean) i.getSerializableExtra("inputEnabled");


        if(i != null) {


            if(!inputsEnabled){

                object = (TicketJsonBuilder) i.getSerializableExtra("issueSelected");

                title.setText(object.getName());
                title.setFocusable(false);
                title.setBackgroundColor(Color.TRANSPARENT);

                date.setText(object.getDate());
                date.setFocusable(false);
                date.setBackgroundColor(Color.TRANSPARENT);

                status.setText(String.valueOf(object.getStatus()));
                status.setFocusable(false);
                status.setBackgroundColor(Color.TRANSPARENT);

                urgency.setText(String.valueOf(object.getUrgency()));
                urgency.setFocusable(false);
                urgency.setBackgroundColor(Color.TRANSPARENT);

                priority.setText(String.valueOf(object.getPriority()));
                priority.setFocusable(false);
                priority.setBackgroundColor(Color.TRANSPARENT);


                description.setText(object.getContent());
                description.setFocusable(false);
                description.setBackgroundColor(Color.TRANSPARENT);

                Log.d("DATA GETTED",object.toti());
            }
        }
        return inflate;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initItems(false);

        FloatingActionButton fab = view.findViewById(R.id.fab);
        final FABRevealMenu fabMenu = view.findViewById(R.id.fabMenu);

        if(fab != null && fabMenu != null){

            setFabRevealMenu(fabMenu);

            fabMenu.setMenuItems(items);

            fabMenu.bindAnchorView(fab);

            fabMenu.setMenuDirection(currentDirection);

            fabMenu.setOnFABMenuSelectedListener(this);

        }
    }


    private void initItems(boolean b) {

        items = new ArrayList<>();
        items.add(new FABMenuItem("Editar", AppCompatResources.getDrawable(getActivity(), R.drawable.ic_edit_black_24dp)));
        items.add(new FABMenuItem("Enviar", AppCompatResources.getDrawable(getActivity(), R.drawable.ic_send_black_24dp)));
        items.add(new FABMenuItem("Guardar", AppCompatResources.getDrawable(getActivity(), R.drawable.ic_save_black_24dp)));
    }

    @Override
    public void onMenuItemSelected(View view, int id) {

        if (id >= 0 && items != null && items.size() > id) {

            Toast.makeText(getActivity(), items.get(id).getTitle() + "Clicked", Toast.LENGTH_SHORT).show();

            switch (items.get(id).getTitle()){
                case "Editar":

                    title.setFocusable(true);
                    date.setFocusable(true);
                    status.setFocusable(true);
                    urgency.setFocusable(true);
                    priority.setFocusable(true);
                    description.setFocusable(true);

                    break;

                case  "Enviar":

                    System.out.println("Enviando");

                    break;

                case "Guardar":

                    System.out.println("Guardando");

                    break;
            }

        }

    }
}
