package com.league.interactive.itl.network;


import com.league.interactive.itl.models.RankPlayer;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


interface BarEndpoint {
    String PARAM_LOCATION = "location";
    String PARAM_RADIUS = "radius";
    String API_TYPE = "type";
    String API_KEY = "key";
    String URL = "/maps/api/place/nearbysearch/json";

    @GET(URL)
    Call<List<RankPlayer>> list(@Query(PARAM_LOCATION) String location,
                                @Query(PARAM_RADIUS) int radius,
                                @Query(API_TYPE) String type,
                                @Query(API_KEY) String apiKey);
}