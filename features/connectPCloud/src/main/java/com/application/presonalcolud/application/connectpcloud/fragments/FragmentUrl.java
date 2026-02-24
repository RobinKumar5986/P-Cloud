package com.application.presonalcolud.application.connectpcloud.fragments;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.application.presonalcolud.application.connectpcloud.databinding.FragmentUrlBinding;
import com.application.presonalcolud.application.remote.interfaces.ResponseListener;
import com.application.presonalcolud.application.remote.models.response.ResponseModel;
import com.application.presonalcolud.application.remote.utils.ApiCallingMethods;

import java.util.List;

public class FragmentUrl extends Fragment implements View.OnClickListener, ResponseListener {
    ProgressDialog dialog;
    FragmentUrlBinding binding;

    public FragmentUrl() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentUrlBinding.inflate(inflater, container, false);
        initializeViews();
        return binding.getRoot();
    }

    private void initializeViews() {
        binding.txtInputUrl.setOnClickListener(this);
        binding.btnSearch.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==binding.btnSearch.getId()){
            dialog=new ProgressDialog(binding.getRoot().getContext());
            dialog.setTitle("Loading...");
            dialog.setMessage("Please wait loading your archive...");
            dialog.setCancelable(false);
            dialog.show();
            if(binding.txtInputUrl.getText().toString().equals(null) || binding.txtInputUrl.getText().toString().length()<=0 )
            {
                Toast.makeText(binding.getRoot().getContext(), "Enter the URL", Toast.LENGTH_SHORT).show();
                return;
            }
            getUrl();
        }

    }

    private void getUrl() {
        String URL=binding.txtInputUrl.getText().toString();
        ApiCallingMethods.getListOfFiles(this,URL,1003);
    }
    @Override
    public void onSuccess(List data, Integer requestCode) {
        if(dialog!=null)
            dialog.dismiss();
    }
    @Override
    public  void onError(String errorMessage, Integer requestCode) {
        if(dialog!=null)
            dialog.dismiss();
        Toast.makeText(requireContext(), errorMessage, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSuccess(Object data, Integer requestCode) {
        if(dialog!=null)
            dialog.dismiss();
        if(data!=null) {
            ResponseModel model = (ResponseModel) data;
            FragmentUrlDirections.ActionFragmentUrlToListOfFilesinArchive direction
                    =FragmentUrlDirections.actionFragmentUrlToListOfFilesinArchive(model);
            Navigation.findNavController(binding.getRoot()).navigate(direction);
        }else{
            Toast.makeText(requireContext(), "Archive is Empty", Toast.LENGTH_SHORT).show();
        }
    }
}