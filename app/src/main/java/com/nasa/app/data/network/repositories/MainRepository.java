package com.nasa.app.data.network.repositories;

import com.nasa.app.data.network.models.response.MarsPhotoResponse;

import io.reactivex.Completable;
import io.reactivex.Single;

public interface MainRepository {
    Single<MarsPhotoResponse> getMarsRoversPhotos(String roverName, int sol, String camera);
}
