package com.miguel.gestorincidenciaapp.DetailedIssue;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.hlab.fabrevealmenu.view.FABRevealMenu;
import com.miguel.gestorincidenciaapp.ListViewIssues.DetailIssueFragment;
import com.miguel.gestorincidenciaapp.R;

public class DetailedIssue extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_issue);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        FloatingActionButton fab = findViewById(R.id.fab);
        FABRevealMenu fabRevealMenu = findViewById(R.id.navigation);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_xml) {
            showXmlFragment();
            return true;
        } else if (id == R.id.nav_code) {
            showCodeFragment();
            return true;
        }

        return false;
    }


    private void showXmlFragment() {
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new DetailIssueFragment()).commit();
    }

    private void showCodeFragment() {
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new DetailIssueFragment()).commit();
    }


}
