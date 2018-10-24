package com.itstarr.sampleproject.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.itstarr.sampleproject.R;

import butterknife.ButterKnife;

public class Fragment3 extends android.support.v4.app.Fragment  {

    public static Fragment3 newInstance() {
        Fragment3 fragment1 = new Fragment3();
        return fragment1;
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.layout3, container, false);

        ButterKnife.bind(this, rootView);


        return rootView;
    }
}
