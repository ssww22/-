package com.example.project2;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    FrameLayout frameLayout;
    HomeFragment homeFragment;
    SearchFragment searchFragment;
    FavoriteFragment favoriteFragment;
    SettingFragment settingFragment;


    BottomNavigationView bottomNavigationView;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        homeFragment = new HomeFragment();
        favoriteFragment = new FavoriteFragment();
        searchFragment = new SearchFragment();
        settingFragment = new SettingFragment();
        init();
        settingListener();

        // 맨 처음 시작할 탭 설정
        getSupportFragmentManager().beginTransaction().replace(R.id.container, homeFragment).commit();




    }



    private void init() {
        frameLayout = findViewById(R.id.container);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
    }

    private void settingListener() {
        bottomNavigationView.setOnNavigationItemSelectedListener(new TabSelectedListener());
    }


    class TabSelectedListener implements BottomNavigationView.OnNavigationItemSelectedListener{
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem){
            int itemId = menuItem.getItemId();
            if (itemId == R.id.fragment_home) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, homeFragment)
                        .commit();
                return true;

            } else if (itemId == R.id.fragment_search) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, searchFragment)
                        .commit();
                return true;
            } else if (itemId == R.id.fragment_favorite) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, favoriteFragment)
                        .commit();
                return true;
            } else if (itemId == R.id.fragment_settings) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, settingFragment)
                        .commit();
                return true;
            }

            return false;

        }



    }
}