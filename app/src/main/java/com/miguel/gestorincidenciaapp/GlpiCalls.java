package com.miguel.gestorincidenciaapp;

import com.miguel.gestorincidenciaapp.Data.SOAnswersResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GlpiCalls {

    @GET("/getFullSession/?session_token=dkppgm6cu0p304lk3di9qm22k7&app_token=5o9yiRFgOUlOVYxZLnF1taKj67lnW4bSDUXGUlAj&username=glpi&password=D1A2I3")
    Call<SOAnswersResponse> getAnswers();



}
