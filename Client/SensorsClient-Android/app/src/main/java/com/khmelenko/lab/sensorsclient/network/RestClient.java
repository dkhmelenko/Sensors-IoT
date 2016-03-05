package com.khmelenko.lab.sensorsclient.network;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author Dmytro Khmelenko (d.khmelenko@gmail.com)
 */
public final class RestClient {

    private static final String ENDPOINT = "http://192.168.178.34:8080";

    private static RestClient sInstance;

    private ApiService mApiService;

    public static RestClient getInstance() {
        if (sInstance == null) {
            sInstance = new RestClient();
        }
        return sInstance;
    }

    private RestClient() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(client)
                .build();

        mApiService = retrofit.create(ApiService.class);
    }

    /**
     * Gets API service
     *
     * @return API service
     */
    public ApiService getService() {
        return mApiService;
    }
}
