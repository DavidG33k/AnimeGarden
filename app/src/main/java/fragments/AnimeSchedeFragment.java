package fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.animegarden.R;


public class AnimeSchedeFragment extends Fragment {

    private String id;
    public AnimeSchedeFragment(String id) {
        // Required empty public constructor
        this.id = id;
        getFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, this).commit();
    }


    public static AnimeSchedeFragment newInstance(String id) {
        AnimeSchedeFragment fragment = new AnimeSchedeFragment(id);

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
        return inflater.inflate(R.layout.fragment_anime_schede, container, false);
    }
}