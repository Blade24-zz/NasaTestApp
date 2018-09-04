package com.nasa.app.di.modules;

import com.nasa.app.di.scopes.ActivityScope;
import com.nasa.app.ui.main.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityModule {

    @ActivityScope
    @ContributesAndroidInjector
    abstract MainActivity mainActivity();
}
