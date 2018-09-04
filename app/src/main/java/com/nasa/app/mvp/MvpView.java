package com.nasa.app.mvp;

import android.support.annotation.LayoutRes;

public interface MvpView<P extends MvpPresenter> {
    @LayoutRes
    int getLayoutId();
    P getPresenter();

    void showProgress();

    void hideProgress();

    void showMessage(String message);
}
