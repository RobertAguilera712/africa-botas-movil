package com.cloudymind.africabotas.api;

import com.cloudymind.africabotas.model.RespuestaLogin;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Login {
    @FormUrlEncoded
    @POST("login/movil")
    Call<RespuestaLogin> login(
            @Field("usuario") String usuario,
            @Field("password") String password
    );
}
