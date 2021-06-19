package com.example.animegarden;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class AdapterFragmentTab extends FragmentPagerAdapter {


        ArrayList<Fragment> fragments = new ArrayList<>();
        ArrayList<String> titleFragments = new ArrayList<>();


    public AdapterFragmentTab(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    public void addFragment(Fragment fragment, String s){
        fragments.add(fragment);
        titleFragments.add(s);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titleFragments.get(position);
    }
}
