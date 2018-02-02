package com.linder.mercados;

import com.linder.mercados.Activities.ResponseMessage;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by linderhassinger on 1/21/18.
 */

public interface ApiService {

    String API_BASE_URL = "";

    @FormUrlEncoded
    @POST("api/v1/login")
    Call<ResponseMessage> loginUsuario(
            @Field("user") String user,
            @Field("password") String password
    );

}