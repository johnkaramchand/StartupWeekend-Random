package com.random.random.random.network;

/**
 * Created by suryamurugan on 28/3/18.
 */

public class ApiUtils {

    //public static final String BASE_URL= "https://adversize.in/";
    public static final String BASE_URL= "https://jiwirooms.com/api/";
    public static UserService getUserService(){

        return RetrofitClient.getClient(BASE_URL).create(UserService.class);

    }
}
