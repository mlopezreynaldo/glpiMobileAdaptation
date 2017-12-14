package com.miguel.gestorincidenciaapp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by miguel on 14/12/2017.
 */

public interface GlpiClient {

    @GET("/initSession/?app_token=5o9yiRFgOUlOVYxZLnF1taKj67lnW4bSDUXGUlAj&login={login}&password=D1A2I3")
    Call<Glpi> initSession(@Path("login") String login, String password);
//    @GET("initSession/?app_token=5o9yiRFgOUlOVYxZLnF1taKj67lnW4bSDUXGUlAj&login={login}&password={password}")
//    Call<Glpi> initSession(@Path("login") String login, @Path("password") String password);

}
