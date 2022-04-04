package com.cloudymind.africabotas.api;

import com.cloudymind.africabotas.model.Producto;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ProductosApi {
    @GET("productos/getAll")
    Call<ArrayList<Producto>> getAll();

    @GET("productos/get/{id}")
    Call<Producto> get(@Path("id") String id);
}
