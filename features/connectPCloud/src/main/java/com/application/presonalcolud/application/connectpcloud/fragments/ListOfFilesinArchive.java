package com.application.presonalcolud.application.connectpcloud.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.application.presonalcolud.application.connectpcloud.databinding.FragmentListOfFilesinArchiveBinding;
import com.application.presonalcolud.application.remote.models.response.ResponseModel;


public class ListOfFilesinArchive extends Fragment {
    FragmentListOfFilesinArchiveBinding binding;
    ResponseModel response;

    public ListOfFilesinArchive() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        response=ListOfFilesinArchiveArgs.fromBundle(getArguments()).getResponse();
        binding = FragmentListOfFilesinArchiveBinding.inflate(inflater, container, false);
        initializeView();
        return binding.getRoot();
    }

    private void initializeView() {
        binding.txtResponse.setText(response.toString());
    }
}