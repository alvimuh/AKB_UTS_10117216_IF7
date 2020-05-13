package com.example.akb_uts_10117216_if7;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.example.akb_uts_10117216_if7.R;
import com.example.akb_uts_10117216_if7.view.DashboardFragment;
import com.example.akb_uts_10117216_if7.view.NotificationsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

public class MainActivity extends AppCompatActivity {

    LinearLayout layout_tab;
    FrameLayout layout_frame;
    ViewPager viewPager;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()){
                case R.id.navigation_home:
                    layout_tab.setVisibility(View.VISIBLE);
                    layout_frame.setVisibility(View.GONE);
                    return true;
                case R.id.navigation_dashboard:
                    layout_tab.setVisibility(View.GONE);
                    layout_frame.setVisibility(View.VISIBLE);
                    load_fragment_bottom(new DashboardFragment());
                    return true;
                case R.id.navigation_notifications:
                    layout_tab.setVisibility(View.GONE);
                    layout_frame.setVisibility(View.VISIBLE);
                    load_fragment_bottom(new NotificationsFragment());
                    return true;
            }
            return false;
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);

        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        layout_tab = findViewById(R.id.layout_tab);
        layout_frame = findViewById(R.id.layout_frame);
        MainAdapter mainAdapter = new MainAdapter(getSupportFragmentManager());
        viewPager = findViewById(R.id.viewpager);

        viewPager.setAdapter(mainAdapter);
    }

    Boolean load_fragment_bottom(Fragment fragment){
        if(fragment != null){
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.layout_frame, fragment).commit();
            return true;
        }
        return false;
    }
}


// 12 mei 2020
// 10117216 - Adi Prayoga - IF7
