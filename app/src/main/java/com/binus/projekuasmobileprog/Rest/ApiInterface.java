package com.binus.projekuasmobileprog.Rest;

import com.binus.projekuasmobileprog.Model.Response;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("/")
    Call<Response> getFilm(

            @Query("s") String nama_film,
            @Query("apikey") String apikey
    );
}
