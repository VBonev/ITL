package com.league.interactive.itl.network;


import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.List;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static okhttp3.logging.HttpLoggingInterceptor.Level.BODY;

public class NetworkClient {

    private Retrofit retrofit;
    private static final String BASE_URL = "https://maps.googleapis.com";

    public NetworkClient() throws NoSuchAlgorithmException, KeyManagementException {

        okhttp3.OkHttpClient.Builder builder = new okhttp3.OkHttpClient.Builder();
        builder.addInterceptor(new HttpLoggingInterceptor().setLevel(BODY));
        okhttp3.OkHttpClient client = builder.build();

        Gson gson = new GsonBuilder().registerTypeAdapter(new TypeToken<List<BarModel>>() {
        }.getType(), new RankPlayerJsonDeserializer()).disableHtmlEscaping().create();

        retrofit = new Retrofit.Builder()
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(BASE_URL)
                .build();
    }

    /**
     *
     * @param location
     * @param radius
     * @param type
     * @param apiKey
     * @return
     */
    public Call<List<BarModel>> getListBars(final String location,
                                            final int radius,
                                            final String type,
                                            final String apiKey) {
        BarEndpoint barEndpoint = retrofit.create(BarEndpoint.class);
        return barEndpoint.list(location, radius, type, apiKey);
    }

}
