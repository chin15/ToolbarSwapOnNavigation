package com.dblackker.toolbarhello;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ToolsFragment extends Fragment {

    public static final String FRAGMENT_TAG = ToolsFragment.class.getSimpleName();

    public static ToolsFragment newInstance() {
        return new ToolsFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tools, container, false);
    }
}
