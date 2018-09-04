package com.nasa.app.ui.base;


import com.nasa.app.mvp.MvpView;

public interface BaseFragmentView<P extends BasePresenter> extends MvpView<P> {

    void onBackPress();

    void changeToolbarTitle(String title);

    void setupToolbar(int homeIcon);

    void showProgress();

    void hideProgress();

    void switchFragment(BaseFragment fragment, boolean addToBackStack);
}
