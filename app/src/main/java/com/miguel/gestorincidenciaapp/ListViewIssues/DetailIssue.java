package com.miguel.gestorincidenciaapp.ListViewIssues;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.hlab.fabrevealmenu.listeners.OnFABMenuSelectedListener;
import com.hlab.fabrevealmenu.view.FABRevealMenu;
import com.miguel.gestorincidenciaapp.R;

public class DetailIssue extends AppCompatActivity implements OnFABMenuSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_issue);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        FloatingActionButton fab = findViewById(R.id.fab);
        FABRevealMenu fabRevealMenu = findViewById(R.id.fabMenu);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });

    }


    @Override
    public void onMenuItemSelected(View view, int id) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }


    private void showXmlFragment() {
       getSupportFragmentManager().beginTransaction().replace(R.id.container, new DetailIssueFragment()).commit();
    }

    private void showCodeFragment() {
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new DetailIssueFragment()).commit();
    }

}
