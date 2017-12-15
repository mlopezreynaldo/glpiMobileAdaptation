package com.miguel.gestorincidenciaapp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

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
//    @GET("initSession/?app_token=5o9yiRFgOUlOVYxZLnF1taKj67lnW4bSDUXGUlAj&login={login}&password={password}")
//    Call<TokenInfo> initSession(@Path("login") String login, @Path("password") String password);

}
