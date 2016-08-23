package com.herokuapp.gymglishwebviewapp.gymglishwebviewapp.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.herokuapp.gymglishwebviewapp.gymglishwebviewapp.R;
import com.herokuapp.gymglishwebviewapp.gymglishwebviewapp.adapters.WebSiteAdapter;
import com.herokuapp.gymglishwebviewapp.gymglishwebviewapp.listners.OnWebSiteChosen;


public class ListFragment extends Fragment {
    private LayoutInflater inflater;
    private OnWebSiteChosen listener;

    public ListFragment() {
        // Required empty public constructor
    }

    public void setInflater(LayoutInflater inflater,OnWebSiteChosen listener)
    {
        this.inflater = inflater;
        this.listener = listener;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        ListView websiteList = (ListView)view.findViewById(R.id.lstFragments);
        WebSiteAdapter adapter = new WebSiteAdapter(inflater);
        adapter.setOnWebsiteChosen(listener);
        websiteList.setAdapter(adapter);
        return view;
    }
}
