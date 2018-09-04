package com.nasa.app.di.modules;


import com.nasa.app.data.network.repositories.MainRepository;
import com.nasa.app.data.network.repositories.MainRepositoryImpl;
import com.nasa.app.data.network.service.CommonApiService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RepositoryModule {

    @Singleton
    @Provides
    MainRepository provideMainRepository(final CommonApiService commonApiService) {
        return new MainRepositoryImpl(commonApiService);
    }

}
