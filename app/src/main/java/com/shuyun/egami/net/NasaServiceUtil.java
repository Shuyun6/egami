package com.shuyun.egami.net;

import com.shuyun.egami.constant.Config;
import com.shuyun.egami.data.entity.ApodData;

import io.reactivex.Observable;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class NasaServiceUtil {

    private static NasaServiceUtil util;

    public static NasaServiceUtil getInstance() {
        if (null == util) {
            synchronized (NasaServiceUtil.class) {
                if (null == util) {
                    util = new NasaServiceUtil();
                }
            }
        }
        return util;
    }

    private NasaServiceUtil(){
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC))
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(NasaService.URL)
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(NasaService.class);

    }

    private NasaService service;

    public Observable<ApodData> getApodData(String date, boolean hd) {
        return service.getApod(Config.INSTANCE.getNASA_KEY(), date, hd);
    }

}
