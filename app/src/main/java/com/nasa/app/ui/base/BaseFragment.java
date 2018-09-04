package com.nasa.app.ui.base;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import dagger.android.support.DaggerFragment;

public abstract class BaseFragment<P extends BasePresenter> extends DaggerFragment implements BaseFragmentView<P> {

    @Inject
    P mPresenter;

    protected Unbinder mUnbinder;

    @Override
    public P getPresenter() {
        return mPresenter;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), container, false);
        mUnbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mPresenter.attachView(this);
        onViewReady(savedInstanceState);
    }

    @IdRes
    public int getFragmentContainer() {
        return 0;
    }

    @Override
    public void onBackPress() {
        getBaseActivity().onBackPressed();
    }


    @Override
    public void showProgress() {
        getBaseActivity().showProgress();
    }

    @Override
    public void hideProgress() {
        getBaseActivity().hideProgress();
    }


    public BaseActivity getBaseActivity() {
        return (BaseActivity) getActivity();
    }

    @Override
    public void switchFragment(BaseFragment fragment, boolean addToBackStack){
        FragmentTransaction fragmentTransaction = getBaseActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(getBaseActivity().getFragmentContainer(), fragment, fragment.getClass().getName());

        if (addToBackStack) {
            fragmentTransaction.addToBackStack(fragment.getClass().getName());
        }
        fragmentTransaction.commit();
    }

    protected abstract void onViewReady(@Nullable Bundle savedInstanceState);

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }

    @Override
    public void showMessage(String message) {
        getBaseActivity().showMessage(message);
    }
}