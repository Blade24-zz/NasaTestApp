package com.nasa.app.data.network.repositories;

import com.nasa.app.data.network.models.response.MarsPhotoResponse;
import com.nasa.app.data.network.service.CommonApiService;
import javax.inject.Inject;
import io.reactivex.Completable;
import io.reactivex.Single;


public class MainRepositoryImpl implements MainRepository {
    private final CommonApiService commonApiService;

    @Inject
    public MainRepositoryImpl(final CommonApiService _commonApiService) {
        this.commonApiService = _commonApiService;
    }

    @Override
    public Single<MarsPhotoResponse> getMarsRoversPhotos(String roverName, int sol, String camera) {
        return this.commonApiService.getMarsRoversPhotos(roverName, sol, camera);
    }
}
