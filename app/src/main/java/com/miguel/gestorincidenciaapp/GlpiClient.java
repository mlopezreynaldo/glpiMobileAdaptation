package com.miguel.gestorincidenciaapp;

import java.util.Date;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
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


    @POST("Ticket")
    @Headers({"Content-Type: application/json","Cache-Control: max-age=640000"})
    Call<TicketJsonBuilder> setNewIssue(

            @Query("app_token") String app_token,
            @Query("session_token") String session_token,
            @Body TicketJsonBuilder input
    );


    /*Ejemplo enviar Ticket: http://5.145.175.176/glpi/apirest.php/Ticket/?app_token=5o9yiRFgOUlOVYxZLnF1taKj67lnW4bSDUXGUlAj&session_token=ols8ve7k2rki62dsqasren6ph5
    {"input": {
        "name": "pene",
        "date": "2017-12-20 22:07:23",
        "users_id_lastupdater": 2,
        "status": 2,
        "users_id_recipient": 2,
        "requesttypes_id": 1,
        "content": "dadada",
        "urgency": 3,
        "impact": 3,
        "priority": 3,
        "itilcategories_id": 0,
        "type": 1,
        "solutiontypes_id": 0,
        "solution": null
   }
}*/

}
