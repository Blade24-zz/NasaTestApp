package com.nasa.app.data.network.service;

import com.nasa.app.data.network.models.response.MarsPhotoResponse;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface CommonApiService {
    @GET("mars-photos/api/v1/rovers/{roverName}/photos")
    Single<MarsPhotoResponse> getMarsRoversPhotos(@Path("roverName") String roverName, @Query("sol") int sol, @Query("camera") String cameraName);
}
