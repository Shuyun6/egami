package com.shuyun.egami.net;

import com.shuyun.egami.data.entity.ApodData;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NasaService {

    String URL = "https://api.nasa.gov/";

    @GET("planetary/apod")
    Observable<ApodData> getApod(@Query("api_key")String key, @Query("date")String date, @Query("hd")boolean full);

}
