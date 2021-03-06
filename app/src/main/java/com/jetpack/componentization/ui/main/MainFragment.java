package com.jetpack.componentization.ui.main;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.QuickContactBadge;
import android.widget.TextView;
import android.widget.Toast;

import com.jetpack.componentization.R;

public class MainFragment extends Fragment {

    private MainViewModel mViewModel;
    Button m;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.main_fragment, container, false);
        m=view.findViewById(R.id.message);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);
        Toast.makeText(getActivity(),"-----"+mViewModel,1).show();
        mViewModel.getUserLiveData().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                m.setText(s);

            }

        });
        m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);
                Toast.makeText(getActivity(),"-----"+mViewModel,1).show();
                mViewModel.setUserLiveData("13345");
            }
        });
    }

}