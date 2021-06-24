package fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.animegarden.AnimeAPI;
import com.example.animegarden.AnimeAdapter;
import com.example.animegarden.R;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    private RecyclerView RecyclerView_popularity;
    private RecyclerView RecyclerView_upcoming;
    private RecyclerView RecyclerView_genre;


    public HomeFragment() {
        // Required empty public constructor
    }


    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @SuppressLint("WrongConstant")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view =  inflater.inflate(R.layout.fragment_home,
                container, false);



        ArrayList<HashMap<String, String>> animeByPopularity = AnimeAPI.getAnimeByPopularity();
        RecyclerView_popularity = view.findViewById(R.id.RecyclerView_popularity);
        AnimeAdapter animeAdapter = new AnimeAdapter(this.getContext(), animeByPopularity, getActivity());
        RecyclerView_popularity.setAdapter(animeAdapter);
        RecyclerView_popularity.setLayoutManager(new LinearLayoutManager(this.getContext(), LinearLayout.HORIZONTAL, false));

        ArrayList<HashMap<String, String>> animeUpComing = AnimeAPI.getUpComingAnime();
        RecyclerView_upcoming = view.findViewById(R.id.RecyclerView_upcoming);
        AnimeAdapter animeAdapter2 = new AnimeAdapter(this.getContext(), animeUpComing, getActivity());
        RecyclerView_upcoming.setAdapter(animeAdapter2);
        RecyclerView_upcoming.setLayoutManager(new LinearLayoutManager(this.getContext(), LinearLayout.HORIZONTAL, false));

        ArrayList<HashMap<String, String>> animeByGenre = AnimeAPI.getAnimeByGenre(1);
        RecyclerView_genre = view.findViewById(R.id.RecyclerView_genre);
        AnimeAdapter animeAdapter3 = new AnimeAdapter(this.getContext(), animeByGenre, getActivity());
        RecyclerView_genre.setAdapter(animeAdapter3);
        RecyclerView_genre.setLayoutManager(new LinearLayoutManager(this.getContext(), LinearLayout.HORIZONTAL, false));

        return view;
    }

}

