package com.example.akb_uts_10117216_if7;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.akb_uts_10117216_if7.view.AboutAppFragment;
import com.example.akb_uts_10117216_if7.view.HomeFragment;

public class MainAdapter extends FragmentStatePagerAdapter {

    private int jumlahTab = 2;

    public MainAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                HomeFragment homeFragment = new HomeFragment();
                return homeFragment;
            case 1:
                AboutAppFragment aboutAppFragment = new AboutAppFragment();
                return aboutAppFragment;
        }
        return null;
    }

    @Override
    public int getCount() {
        return jumlahTab;
    }
}


// 12 mei 2020
// 10117216 - Adi Prayoga - IF7
