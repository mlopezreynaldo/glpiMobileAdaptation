package com.miguel.gestorincidenciaapp;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A placeholder fragment containing a simple view.
 */
public class DetailIssueFragment extends Fragment {

    public DetailIssueFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_detail_issue, container, false);

        Intent i = getActivity().getIntent();

        if(i != null){
            String jsonBuilder = (String) i.getSerializableExtra("issues");

            if(jsonBuilder != null){

                Log.d("PEPEP","Text To Show ");

            }
        }

        return inflate;
    }
}
