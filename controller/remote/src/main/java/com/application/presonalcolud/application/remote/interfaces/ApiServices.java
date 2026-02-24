package com.application.presonalcolud.application.remote.interfaces;




import com.application.presonalcolud.application.remote.models.response.BaseResponse;
import com.application.presonalcolud.application.remote.models.response.ResponseModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface ApiServices {
    @GET
    Call<ResponseModel> getListOfFiles(@Url String url);
}
