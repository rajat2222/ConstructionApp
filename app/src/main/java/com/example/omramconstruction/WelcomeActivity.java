package com.example.omramconstruction;

import static com.google.android.material.navigation.NavigationView.*;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.example.omramconstruction.ui.home.Home;
import com.google.android.material.navigation.NavigationView;
import com.mancj.materialsearchbar.MaterialSearchBar;

import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;


public class WelcomeActivity extends AppCompatActivity implements OnNavigationItemSelectedListener, PopupMenu.OnMenuItemClickListener, MaterialSearchBar.OnSearchActionListener, androidx.appcompat.widget.PopupMenu.OnMenuItemClickListener {

    MaterialSearchBar searchBar;
    private DrawerLayout drawer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //for loading default home activity
        FragmentTransaction tx = getSupportFragmentManager().beginTransaction();
        tx.replace(R.id.nav_host_fragment, new Home());
        tx.commit();
        setContentView(R.layout.activity_welcome);
        // Toolbar toolbar =(Toolbar)findViewById(R.id.toolbar);
        // setSupportActionBar(toolbar);


        //shared preferences   //navigation drawer
        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //mycode
        View hView = navigationView.getHeaderView(0);
        TextView tv_name = (TextView) hView.findViewById(R.id.navigation_name);
        SharedPreferences sp = getSharedPreferences("MYPREF", MODE_PRIVATE);
        tv_name.setText(sp.getString("Tid", ""));

        //searchBar is mancj Materail navigation id
        searchBar = findViewById(R.id.searchBar);
        searchBar.setOnSearchActionListener(this);

        //Option menu - Popup menu Code
        searchBar.inflateMenu(R.menu.menu); //inflate with mancj library to menu file
        searchBar.getMenu().setOnMenuItemClickListener(this); //getting the value by using interface


        searchBar.setText("Happy to Help");
        Log.d("LOG_TAG", getClass().getSimpleName() + ": text " + searchBar.getText());
        searchBar.setCardViewElevation(10);
        searchBar.addTextChangeListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Log.d("LOG_TAG", getClass().getSimpleName() + " text changed " + searchBar.getText());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }

        });

    /*    final FloatingActionButton fab = findViewById(R.id.fab);
        fab.setImageResource(R.drawable.ic_live_help_white_24dp);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Welcome.this, Query.class));
            }
        });*/

    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.

        Fragment fragment = null;
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

        int id = item.getItemId();

        if (id == R.id.nav_home) {
            fragment = new Home();
        } /*else if (id == R.id.nav_learn) {
            fragment = new LearnFragment();
        } else if (id == R.id.nav_quiz) {
            fragment = new QuizFragment();
        } else if (id == R.id.nav_Interview) {
            fragment = new InterviewquesFragment();
        } else if (id == R.id.nav_new) {
            fragment = new WhatsnewFragment();
        }
        else if(id == R.id.nav_aboutus)
        {
            fragment = new AboutusFragment();
        }*/

        ft.replace(R.id.nav_host_fragment, fragment);
        ft.addToBackStack(null);
        ft.commit();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onSearchStateChanged(boolean enabled) {
    }

    @Override
    public void onSearchConfirmed(CharSequence text) {

    }

    @Override
    public void onButtonClicked(int buttonCode) {
        switch (buttonCode) {
            case MaterialSearchBar.BUTTON_NAVIGATION:
                drawer.openDrawer(GravityCompat.START);
                break;
            case MaterialSearchBar.BUTTON_SPEECH:
                break;
            case MaterialSearchBar.BUTTON_BACK:
                searchBar.closeSearch();
                break;
        }
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {

        //MenuInflater inflater = getMenuInflater();
        //inflater.inflate(R.menu.menu, );

        switch (item.getItemId()) {
            case R.id.action_settings:
                actionSetting();
                return true;
            case R.id.action_logout:
                actionLogout();
                SharedPreferences sharedPreferences = getSharedPreferences("MYPREF", MODE_PRIVATE);
                if(sharedPreferences.contains("Tid"))
                {
                    item.setVisible(true);
                }
                else
                {
                    item.setVisible(false);
                }
                return true;
            case R.id.action_Profile:
                actionProfile();
                return true;
            default:
                return true;
        }

    }

    private void actionProfile() {
        SharedPreferences sharedPreferences = getSharedPreferences("MYPREF", MODE_PRIVATE);
        if(sharedPreferences.contains("Tid")) {
            Toast.makeText(getApplicationContext(), "Profile", Toast.LENGTH_LONG).show();
            startActivity(new Intent(WelcomeActivity.this, Demo.class));
        }
        else {
            Toast.makeText(getApplicationContext(),"Please Login First",Toast.LENGTH_LONG).show();
            //Fragment fragment = null;
            //fragment = new ProfileFragment();
            //FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            //ft.replace(R.id.nav_host_fragment, fragment);
            //ft.addToBackStack(null);
            //ft.commit();
        }
        //startActivity(new Intent(Welcome.this, ProfileFragment.class));
    }

    private void actionLogout() {
        SharedPreferences sharedPreferences = getSharedPreferences("MYPREF", MODE_PRIVATE);
        if(sharedPreferences.contains("Tid"))
        {
            Toast.makeText(getApplicationContext(),"Logging Out",Toast.LENGTH_LONG).show();
            SharedPreferences.Editor editor=sharedPreferences.edit();
            editor.remove("Tid");
            editor.putString("mgs","Logged out Successfully");
            editor.commit();
            startActivity(new Intent(WelcomeActivity.this, Demo.class));
        }
        else
        {
            Toast.makeText(getApplicationContext(),"Please Login First",Toast.LENGTH_LONG).show();
        }


        //startActivity(new Intent(Welcome.this,Query.class));
    }

    private void actionSetting() {
        Toast.makeText(getApplicationContext(),"Setting",Toast.LENGTH_LONG).show();
        startActivity(new Intent(WelcomeActivity.this,Demo.class));
    }


    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}
/*

   @Override
   public boolean onCreateOptionsMenu(Menu menu) 3{
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        //menu.findItem(R.id.mt_menu).setEnabled(isFinalized);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.action_settings:
                actionSetting();
                return true;
            case R.id.action_logout:
                actionLogout();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    */
        /*
    public  void loadSlides(View v)
    {
        new PreferenceManager(this).checkPreference();
        startActivity(new Intent(this, Appintro.class));
        finish();
    }
} */



