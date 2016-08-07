package com.ticket.flight.flightprojectwithnavigation.fragments;


import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ticket.flight.flightprojectwithnavigation.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentAboutJump2screen extends Fragment {
    View rootview;
    @Nullable

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.fragment_about_jump2screen, container, false);
        return rootview;
    }
}




