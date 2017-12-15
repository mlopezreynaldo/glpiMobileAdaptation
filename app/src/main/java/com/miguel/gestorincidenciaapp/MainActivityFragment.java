package com.miguel.gestorincidenciaapp;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import java.io.IOException;

import okhttp3.ResponseBody;
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


        Retrofit.Builder builder = new Retrofit
                .Builder()
                .baseUrl("http://5.145.175.176/glpi/apirest.php/")
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();

        GlpiClient glpi = retrofit.create(GlpiClient.class);
        Call<TokenInfo> call = glpi.initSession("glpi", "D1A2I3", "5o9yiRFgOUlOVYxZLnF1taKj67lnW4bSDUXGUlAj");

        call.enqueue(new Callback<TokenInfo>() {
            @Override
            public void onResponse(Call<TokenInfo> call, Response<TokenInfo> response) {
                Log.d("URL", call.request().url().toString()); // here
                if(response.isSuccessful()){
                    TokenInfo data = response.body();
                    Log.d("DATA", "DATA" + data.toString());

                    Toast.makeText(getContext(),"DATA" + data.toString(), Toast.LENGTH_LONG).show();
                } else {
                    ResponseBody body = response.errorBody();
                    Log.d("ERROR", body.toString());

                    try {
                        Toast.makeText(getContext(), "ERROR" + body.string(), Toast.LENGTH_LONG).show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<TokenInfo> call, Throwable t) {

                Context context = getContext();
                Toast.makeText(context, t.getMessage(), Toast.LENGTH_LONG).show();

            }
        });
        return view;

    }
}
