package com.miguel.gestorincidenciaapp;

/**
 * Created by miguel on 13/12/2017.
 */

public class ApiUtils {

    public static final String BASE_URL = "http://5.145.175.176/glpi/apirest.php";

    public static GlpiCalls getGlpiCalls(){

        return RetrofitClient.getClient(BASE_URL).create(GlpiCalls.class);

    }



}
