package com.cloudymind.africabotas.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Servicio {
    private final String url="https://africa-botas.herokuapp.com/";
    public Retrofit createService(){
        return new Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build();
    }
}
