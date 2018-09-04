package com.nasa.app.ui.base;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;


import com.nasa.R;
import com.nasa.app.mvp.MvpView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import dagger.android.support.DaggerAppCompatActivity;

public abstract class BaseActivity<P extends BasePresenter> extends DaggerAppCompatActivity implements MvpView<P> {

    @Inject
    P presenter;

    private Unbinder unbinder;
    private AlertDialog progressDialog;

    private View mView;


    @Override
    @CallSuper
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupButterKnife();
        if (presenter != null) {
            presenter.attachView(this);
            presenter.onMvpViewAttach(savedInstanceState == null);
        }
        onViewReady(savedInstanceState);
    }

    @Override
    public P getPresenter() {
        return presenter;
    }

    @IdRes
    public int getFragmentContainer() {
        return 0;
    }


    private void setupButterKnife() {
        if (getLayoutId() == - 1) return;
        mView = LayoutInflater.from(this).inflate(getLayoutId(), null);
        setContentView(mView);
        unbinder = ButterKnife.bind(this);
    }

    @CallSuper
    @Override
    protected void onStart() {
        super.onStart();
    }

    @CallSuper
    @Override
    protected void onStop() {
        super.onStop();
        if (presenter != null) {
            presenter.detachView();
        }
    }

    @CallSuper
    @Override
    protected void onResume() {
        super.onResume();
        if (presenter != null) {
            presenter.attachView(this);
        }
    }

    public void refreshButterKnife(){
        unbinder.unbind();
        unbinder = ButterKnife.bind(this);
    }


    @Override
    @CallSuper
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            if (isFinishing()) presenter.destroy();
        }
        if (unbinder != null)
            unbinder.unbind();
    }

    public void showProgress() {
        if(progressDialog != null && progressDialog.isShowing()) return;
        showProgress(true);
    }

    public void hideProgress() {
        if (progressDialog != null) {
            progressDialog.cancel();
        }
    }

    public void showProgress(boolean isDismissible) {
        InputMethodManager imm = (InputMethodManager) this.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(this.getWindow().getDecorView().getWindowToken(), 0);
        AlertDialog.Builder builderVal = new AlertDialog.Builder(this, R.style.ProgressDialogTheme);
        View holder = View.inflate(this, R.layout.dialog_progress, null);
        builderVal.setView(holder);
        builderVal.setCancelable(false);
        builderVal.setOnKeyListener((dialog, keyCode, event) -> {
            if (keyCode == KeyEvent.KEYCODE_BACK) {
                if (isDismissible)
                    dialog.dismiss();
                return true;
            }
            return false;

        });
        progressDialog = builderVal.show(); //TODO: Activity com.twelve.app.ui.main.MainActivity has leaked window DecorView@f23a80[] that was originally added here
    }

    @Override
    public void showMessage(String message) {
        Snackbar snack = Snackbar.make(mView, message, Snackbar.LENGTH_LONG);
        View view = snack.getView();
        view.setBackgroundColor(getResources().getColor(R.color.baseBackground));
        TextView tv = view.findViewById(android.support.design.R.id.snackbar_text);
        tv.setTextColor(Color.BLACK);
        snack.show();
    }

    protected abstract void onViewReady(Bundle savedInstanceState);
}