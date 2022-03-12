package com.example.sneakerdex;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView bottomNavigationView;

    SearchFragment searchFragment = new SearchFragment();
    FavoriteFragment favoriteFragment = new FavoriteFragment();
    AccountFragment accountFragment = new AccountFragment();
    HomeFragment homeFragment = new HomeFragment();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.home);

        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().replace(androidx.appcompat.R.id.action_bar_container, new SearchFragment()).commit();
        }
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.home:
                getSupportFragmentManager().beginTransaction().replace(androidx.appcompat.R.id.action_bar_container, homeFragment).commit();
                return true;

            case R.id.search:
                getSupportFragmentManager().beginTransaction().replace(androidx.appcompat.R.id.action_bar_container, searchFragment).commit();
                return true;

            case R.id.favorite:
                getSupportFragmentManager().beginTransaction().replace(androidx.appcompat.R.id.action_bar_container, favoriteFragment).commit();
                return true;
            case R.id.account:
                getSupportFragmentManager().beginTransaction().replace(androidx.appcompat.R.id.action_bar_container, accountFragment).commit();
                return true;
        }
        return false;
    }
    }
