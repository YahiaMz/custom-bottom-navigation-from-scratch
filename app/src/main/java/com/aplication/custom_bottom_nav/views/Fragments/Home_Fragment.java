package com.aplication.custom_bottom_nav.views.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.ScaleAnimation;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.aplication.custom_bottom_nav.R;

public class Home_Fragment extends Fragment {
    private Context context;
    private View view;
    public Home_Fragment(Context context) {
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
          view = LayoutInflater.from(context).inflate(R.layout.home_fargment, null);


    return  view;
    }

}
