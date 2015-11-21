package com.example.andela.lukaround.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.andela.lukaround.R;

/**
 * Created by andela on 11/21/15.
 */
public class Timeline extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.home_timeline,container,false);
    }
    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
