package com.linder.mercados;

import com.linder.mercados.Activities.ResponseMessage;
import com.linder.mercados.Activities.Usuario;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by linderhassinger on 1/21/18.
 */

public interface ApiService {

    String API_BASE_URL = "http://josekri3g-001-site1.atempurl.com/";

    @FormUrlEncoded
    @POST("api/login")
    Call<ResponseMessage> loginUsuario(
            @Field("username") String user,
            @Field("password") String password,
            @Field("grant_type") String grant_type
    );

    @GET("api/InfoClient")
    Call<List<Usuario>> getUsuario(@Header("Authorization") String value);


}
