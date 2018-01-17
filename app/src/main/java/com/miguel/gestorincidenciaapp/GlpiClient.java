package com.miguel.gestorincidenciaapp;


import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

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


    @POST("Ticket")
    @Headers({"Content-Type: application/json","Cache-Control: max-age=640000"})
    Call<TicketJsonBuilder> setNewIssue(

            @Query("app_token") String app_token,
            @Query("session_token") String session_token,
            @Body Map<String, TicketJsonBuilder> input
    );

    @POST("User")
    @Headers({"Content-Type: application/json","Cache-Control: max-age=640000"})
    Call<RegisterUser> registerUser(

            @Query("app_token") String app_token,
            @Query("session_token") String session_token,
            @Body Map<String, RegisterUser> input
    );


    @GET("Ticket")
    Call<List<TicketJsonBuilder>> getAllIssues(
            @Query("app_token") String app_token,
            @Query("session_token") String session_token
    );



}
