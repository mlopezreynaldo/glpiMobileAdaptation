package com.miguel.gestorincidenciaapp.DetailedIssue;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputEditText;
import android.os.Bundle;
import android.support.v7.content.res.AppCompatResources;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.hlab.fabrevealmenu.enums.Direction;
import com.hlab.fabrevealmenu.listeners.OnFABMenuSelectedListener;
import com.hlab.fabrevealmenu.model.FABMenuItem;
import com.hlab.fabrevealmenu.view.FABRevealMenu;
import com.miguel.gestorincidenciaapp.APInterface.GlpiClient;
import com.miguel.gestorincidenciaapp.FabBaseFragment;
import com.miguel.gestorincidenciaapp.R;
import com.miguel.gestorincidenciaapp.POJO.TicketJsonBuilder;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DetailedIssueFragment extends FabBaseFragment implements OnFABMenuSelectedListener{

    private TicketJsonBuilder object;
    private TextInputEditText title;
    private TextInputEditText date;
    private Spinner urgency;
    private Spinner priority;
    private TextInputEditText description;
    private Spinner statusSpiner;
    private boolean inputsEnabled;
    private ArrayList<FABMenuItem> items;
    private Direction currentDirection = Direction.UP;
    private boolean newSend;
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private String idIssue = "";
    private GlpiClient glpi;
    private String apptoken = "5o9yiRFgOUlOVYxZLnF1taKj67lnW4bSDUXGUlAj";
    private String sessionToken;
    private Retrofit retrofit;

    public DetailedIssueFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_detailed_issue, container, true);

//        SharedPreferences sh = getActivity().getPreferences(Context.MODE_PRIVATE);
//        sessionToken = sh.getString("session_token_shared", "");
//        Log.i("TOKEN_NEW", sessionToken);

        Retrofit.Builder builder = new Retrofit
                .Builder()
                .baseUrl("http://5.145.175.176/glpi/apirest.php/")
                .addConverterFactory(GsonConverterFactory.create());
        retrofit = builder.build();

        glpi = retrofit.create(GlpiClient.class);

        title = inflate.findViewById(R.id.txtTitleIssue);
        date = inflate.findViewById(R.id.dateIssue);
        urgency = inflate.findViewById(R.id.txtUrgency);
        priority = inflate.findViewById(R.id.txtPriority);
        description = inflate.findViewById(R.id.description);
        statusSpiner = inflate.findViewById(R.id.spn_Status);

        Intent i = getActivity().getIntent();
        inputsEnabled = (boolean) i.getSerializableExtra("inputEnabled");
        sessionToken = (String) i.getSerializableExtra("session");
        idIssue = (String) i.getSerializableExtra("id");

        if(inputsEnabled){

            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(), R.array.status_labels, R.layout.support_simple_spinner_dropdown_item);
            adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
            statusSpiner.setAdapter(adapter);

            ArrayAdapter<CharSequence> urgencyAD = ArrayAdapter.createFromResource(getActivity(), R.array.urgency_label, R.layout.support_simple_spinner_dropdown_item);
            urgencyAD.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
            urgency.setAdapter(urgencyAD);

            ArrayAdapter<CharSequence> priorityAD = ArrayAdapter.createFromResource(getActivity(), R.array.priority_label, R.layout.support_simple_spinner_dropdown_item);
            adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
            priority.setAdapter(priorityAD);

            title.setText("");
            title.setFocusable(true);

            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            date.setText(sdf.format(timestamp));
            date.setFocusable(false);
            date.setBackgroundColor(Color.TRANSPARENT);

            statusSpiner.setPrompt("Estado");
//            statusSpiner.setSelection(0);
            statusSpiner.setEnabled(true);

            urgency.setSelection(1);
            urgency.setEnabled(true);

            priority.setSelection(0);
            priority.setEnabled(true);

            description.setText("");
            description.setFocusable(true);

            newSend = true;


        } else {
            if (i != null) {
                if (!inputsEnabled) {

                    object = (TicketJsonBuilder) i.getSerializableExtra("issueSelected");

                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(), R.array.status_labels, R.layout.support_simple_spinner_dropdown_item);
                    adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
                    statusSpiner.setAdapter(adapter);

                    ArrayAdapter<CharSequence> urgencyAD = ArrayAdapter.createFromResource(getActivity(), R.array.urgency_label, R.layout.support_simple_spinner_dropdown_item);
                    urgencyAD.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
                    urgency.setAdapter(urgencyAD);

                    ArrayAdapter<CharSequence> priorityAD = ArrayAdapter.createFromResource(getActivity(), R.array.priority_label, R.layout.support_simple_spinner_dropdown_item);
                    adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
                    priority.setAdapter(priorityAD);

                    title.setText(object.getName());
                    title.setFocusable(false);
                    title.setBackgroundColor(Color.TRANSPARENT);

                    date.setText(object.getDate());
                    date.setFocusable(false);
                    date.setBackgroundColor(Color.TRANSPARENT);

                    statusSpiner.setSelection(object.getStatus());
                    statusSpiner.setPrompt("Estado");
                    statusSpiner.setEnabled(false);
                    statusSpiner.setBackgroundColor(Color.TRANSPARENT);

                    urgency.setSelection(object.getUrgency());
                    urgency.setEnabled(false);
                    urgency.setBackgroundColor(Color.TRANSPARENT);

                    priority.setSelection(object.getPriority());
                    priority.setEnabled(false);
                    priority.setBackgroundColor(Color.TRANSPARENT);


                    description.setText(object.getContent());
                    description.setFocusable(false);
                    description.setBackgroundColor(Color.TRANSPARENT);

                    newSend = false;
                }
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

                    title.setFocusableInTouchMode(true);
                    title.requestFocus();
                    final InputMethodManager inputMethodManager = (InputMethodManager) getContext()
                            .getSystemService(Context.INPUT_METHOD_SERVICE);
                    inputMethodManager.showSoftInput(title, InputMethodManager.SHOW_IMPLICIT);
                    title.setSelection(title.getText().length());

                    statusSpiner.setEnabled(true);
                    urgency.setEnabled(true);
                    priority.setEnabled(true);
                    description.setFocusableInTouchMode(true);

                    break;

                case  "Enviar":

                    TicketJsonBuilder newIssue = null;
                    Long s = statusSpiner.getSelectedItemId();
                    Long u = urgency.getSelectedItemId();
                    Long p = priority.getSelectedItemId();

                    int status = p.intValue();
                    int urgency = u.intValue();
                    int priority = p.intValue();

                    newIssue = new TicketJsonBuilder(title.getText().toString(),
                            date.getText().toString(),
                            status,
                            description.getText().toString(),
                            urgency,
                            priority,
                            1
                    );

                    if(newSend){

                        Map<String, TicketJsonBuilder> map = new HashMap<>();
                        map.put("input", newIssue);

                        Call<TicketJsonBuilder> call = glpi.setNewIssue(apptoken,sessionToken, map);
                        call.enqueue(new Callback<TicketJsonBuilder>() {
                            @Override
                            public void onResponse(Call<TicketJsonBuilder> call, Response<TicketJsonBuilder> response) {

                                if(response.isSuccessful()){

                                    Toast.makeText(getContext(),"DATA" + response.headers(), Toast.LENGTH_LONG).show();
                                    Log.d("RESPUESTA",response.body().toString());

                                } else {

                                    Toast.makeText(getContext(),"DATA" + response.isSuccessful(), Toast.LENGTH_LONG).show();
                                    Log.d("RESPUESTA",response.toString() + "   " + response.headers());

                                }
                            }
                            @Override
                            public void onFailure(Call<TicketJsonBuilder> call, Throwable t) {
                            }
                        });


                    } else {



                    }
                    Log.d("NEWISSUE", newIssue.toString());

                    break;

                case "Guardar":

                    System.out.println("Guardando");

                    break;
            }
        }
    }
}
