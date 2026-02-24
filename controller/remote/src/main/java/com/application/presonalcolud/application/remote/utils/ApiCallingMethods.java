package com.application.presonalcolud.application.remote.utils;

import com.application.presonalcolud.application.remote.interfaces.ApiServices;
import com.application.presonalcolud.application.remote.interfaces.ResponseListener;
import com.application.presonalcolud.application.remote.interseptor.RetrofitClient;
import com.application.presonalcolud.application.remote.managers.ApiManager;
import com.application.presonalcolud.application.remote.managers.ApiUriManager;
import com.application.presonalcolud.application.remote.models.response.BaseResponse;
import com.application.presonalcolud.application.remote.models.response.ResponseModel;

import java.util.List;

import retrofit2.Call;

public class ApiCallingMethods extends ApiManager {
    public static void getListOfFiles(ResponseListener listener, String URL,Integer requestCode){
        Call<ResponseModel> call= RetrofitClient.getRetrofit().create(ApiServices.class).getListOfFiles(URL);
        getNoListData(listener,call,requestCode);
    }

}
