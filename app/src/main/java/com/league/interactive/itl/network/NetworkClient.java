package com.league.interactive.itl.network;


import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.List;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.league.interactive.itl.models.DummyModel;
import com.league.interactive.itl.models.RankPlayer;

import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static okhttp3.logging.HttpLoggingInterceptor.Level.BODY;

public class NetworkClient {

    private Retrofit retrofit;
    private static final String BASE_URL = "http://pt.tennisportal.bg";

    public NetworkClient() throws NoSuchAlgorithmException, KeyManagementException {

        okhttp3.OkHttpClient.Builder builder = new okhttp3.OkHttpClient.Builder();
        builder.addInterceptor(new HttpLoggingInterceptor().setLevel(BODY));
        okhttp3.OkHttpClient client = builder.build();

        Gson gson = new GsonBuilder().
                registerTypeAdapter(new TypeToken<List<DummyModel>>(){}.getType(), new RankPlayerJsonDeserializer())
                .disableHtmlEscaping()
                .create();

        retrofit = new Retrofit.Builder()
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(BASE_URL)
                .build();
    }


    public Call<List<DummyModel>> getUserProfile() {
        RankPlayerEndpoint rankPlayerEndpoint = retrofit.create(RankPlayerEndpoint.class);
        return rankPlayerEndpoint.list();
    }

}
