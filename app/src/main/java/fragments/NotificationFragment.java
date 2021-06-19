package fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.animegarden.AdapterFragmentTab;
import com.example.animegarden.DaVedereFragment;
import com.example.animegarden.HomePageActivity;
import com.example.animegarden.InCorsoFragment;
import com.example.animegarden.R;
import com.google.android.material.tabs.TabLayout;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NotificationFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NotificationFragment extends Fragment {

   TabLayout tabLayout;
   ViewPager viewPager;

    public NotificationFragment() {
        // Required empty public constructor
    }


    public static NotificationFragment newInstance() {
        NotificationFragment fragment = new NotificationFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_notification, container, false);

        FragmentManager fragmentManager = getFragmentManager();
        tabLayout = view.findViewById(R.id.tabs);
        viewPager = view.findViewById(R.id.vp);
        tabLayout.setupWithViewPager(viewPager);
        AdapterFragmentTab adapterFragmentTab = new AdapterFragmentTab(fragmentManager, FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        adapterFragmentTab.addFragment(new VistiFragment(), "Visti");
        adapterFragmentTab.addFragment(new DaVedereFragment(), "Da vedere");
        adapterFragmentTab.addFragment(new InCorsoFragment(), "In Corso");
        viewPager.setAdapter(adapterFragmentTab);
        return view;
    }
}