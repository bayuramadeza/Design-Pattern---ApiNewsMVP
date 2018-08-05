package com.easeel.apinewamvp.interfaces;

import com.easeel.apinewamvp.models.Response;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("top-headlines?country=id&category=business&apiKey=b6dd86368b884906ad634bb72e268fbf")
    Call<Response> listNews();
}
