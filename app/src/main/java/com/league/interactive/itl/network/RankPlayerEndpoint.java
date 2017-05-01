package com.league.interactive.itl.network;


import com.league.interactive.itl.models.DummyModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;


interface RankPlayerEndpoint {
    String URL = "/rest_content/node";

    @GET(URL)
    Call<List<DummyModel>> list();
}