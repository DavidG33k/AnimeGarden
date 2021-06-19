package com.example.animegarden;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link InCorsoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InCorsoFragment extends Fragment {


    public InCorsoFragment() {
        // Required empty public constructor
    }


    public static InCorsoFragment newInstance() {
        InCorsoFragment fragment = new InCorsoFragment();
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
        return inflater.inflate(R.layout.fragment_in_corso, container, false);
    }
}