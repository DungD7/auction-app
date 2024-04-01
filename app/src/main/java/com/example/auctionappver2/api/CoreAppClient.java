package com.example.auctionapp.api;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class CoreAppClient {
    private static Retrofit retrofit = null;



    public static Retrofit getClient() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        String url = "";
        httpClient.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request original = chain.request();
                String basicAuth = "Bearer " + "a60bd62fed0cf1076e93af76114f196bd9c5a48155b2bac88afe15c49595414b";
                // Request customization: add request headers
                Request.Builder requestBuilder = original.newBuilder()
                        .addHeader("Content-Type","application/json; charset=utf-8")
                        .addHeader("Cache-Control","no-cache")
                        .addHeader("Authorization", basicAuth);
                Request request = requestBuilder.build();
                Response response = chain.proceed(request);

                return response;

            }
        });

        httpClient.addInterceptor(logging);
        OkHttpClient okHttpClient = httpClient.build();
        retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }
}
