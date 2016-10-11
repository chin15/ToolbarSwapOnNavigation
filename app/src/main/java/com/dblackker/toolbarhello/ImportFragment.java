package com.dblackker.toolbarhello;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ImportFragment extends Fragment {

    public static final String FRAGMENT_TAG = ImportFragment.class.getSimpleName();

    public static ImportFragment newInstance() {
        return new ImportFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_import, container, false);
    }
}
