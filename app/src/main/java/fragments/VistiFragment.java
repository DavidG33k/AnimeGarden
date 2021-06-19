package fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.animegarden.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link VistiFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class VistiFragment extends Fragment {



    public VistiFragment() {
        // Required empty public constructor
    }


    public static VistiFragment newInstance() {
        VistiFragment fragment = new VistiFragment();

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
        return inflater.inflate(R.layout.fragment_visti, container, false);
    }
}