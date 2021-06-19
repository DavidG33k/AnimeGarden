package com.example.animegarden;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.HashMap;

import fragments.*;


public class HomePageActivity extends AppCompatActivity {

     public FragmentManager fragmentManager;


    private static StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build(); //usato per fixare l'operazione di GET

    private BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;

            switch (item.getItemId()){
                case R.id.home:
                    selectedFragment = new HomeFragment();
                    break;
                case R.id.notification:
                    selectedFragment = new NotificationFragment();
                    break;
                case R.id.profile:
                    selectedFragment = new ProfileFragment();
                    break;
                case R.id.search:
                    selectedFragment = new SearchFragment();
                    break;



            }

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, selectedFragment)
                    .commit();

            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        fragmentManager = getSupportFragmentManager();
        StrictMode.setThreadPolicy(policy); //usato per fixare l'operazione di GET

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomnav);
        bottomNavigationView.setOnNavigationItemSelectedListener(navigationItemSelectedListener);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, new HomeFragment())
                .commit();


    }



}

