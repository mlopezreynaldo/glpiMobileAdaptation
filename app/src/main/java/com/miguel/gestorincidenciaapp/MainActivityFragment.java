package com.miguel.gestorincidenciaapp;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ListView listView = (ListView) view.findViewById(R.id.list_item_pagination_text);


        Retrofit.Builder builder = new Retrofit.Builder().baseUrl("http://5.145.175.176/glpi/apirest.php/").addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = builder.build();

//        GlpiClient glpi = retrofit.create(GlpiClient.class);
//        Call<Glpi> call = glpi.initSession("glpi", "D1A2I3");
//
//        call.enqueue(new Callback<Glpi>() {
//            @Override
//            public void onResponse(Call<Glpi> call, Response<Glpi> response) {
//
//            }
//
//            @Override
//            public void onFailure(Call<Glpi> call, Throwable t) {
//
//                Context context = getContext();
//                Toast.makeText(context,"ERROR", Toast.LENGTH_SHORT).show();
//
//            }
//        });
//        Context context = getContext();
//        Toast.makeText(context,"ERROR", Toast.LENGTH_SHORT).show();
        return view;

    }
}
