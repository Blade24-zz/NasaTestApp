package com.nasa.app.ui.base;

import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;


import com.nasa.app.mvp.MvpPresenter;
import com.nasa.app.mvp.MvpView;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public abstract class BasePresenter<V extends MvpView> implements MvpPresenter<V> {

    private final CompositeDisposable disposables = new CompositeDisposable();
    private final List<Runnable> commands = new ArrayList<>();

    @Nullable
    private V mvpView;

    @CallSuper
    @Override
    public void attachView(final V view) {
        mvpView = view;
    }

    @Override
    public final V getView() {
        return mvpView;
    }

    protected void onMvpViewAttach(final boolean isFirstTime) { }

    @Override
    public final boolean isViewAttached() {
        return mvpView != null;
    }

    @Override
    public final void addDisposable(@NonNull final Disposable disposable) {
        disposables.add(disposable);
    }


    @Override
    public void removeDisposable(@NonNull final Disposable subscription) {
        disposables.remove(subscription);
    }

    @Override
    public void detachView() {
        mvpView = null;
    }

    @Override
    public void destroy() {
        disposables.clear();
    }
}