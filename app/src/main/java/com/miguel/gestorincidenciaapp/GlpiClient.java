package com.miguel.gestorincidenciaapp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
//https://weex.apache.org/
/**
 * Created by miguel on 14/12/2017.
 */

public interface GlpiClient {

    @GET("initSession")
    Call<TokenInfo> initSession(
            @Query("login") String login,
            @Query("password") String password,
            @Query("app_token") String appToken
    );

    @GET("getFullSession")
    Call<TokenInfo> getFullSession (
            @Query("session_token") String sessionToken,
            @Query("app_token") String appToken
    );

}
