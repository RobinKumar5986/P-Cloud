package com.application.presonalcolud.application.remote.interfaces;

import java.util.List;

public interface ResponseListener<T>{
    void onSuccess(List<T> data,Integer requestCode);
    void onError(String errorMessage,Integer requestCode);
    void onSuccess(T data,Integer requestCode);
}
