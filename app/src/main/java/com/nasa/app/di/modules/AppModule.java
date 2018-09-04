package com.nasa.app.di.modules;

import android.content.Context;

import com.nasa.app.App;
import com.nasa.app.data.network.repositories.MainRepository;
import com.nasa.app.data.network.service.CommonApiService;

import dagger.Binds;
import dagger.Module;

@Module(includes = {NetworkModule.class, RepositoryModule.class})
public abstract class AppModule {
    @Binds
    abstract Context application(final App app);

    abstract CommonApiService apiService();

    abstract MainRepository mainRepository();
}
