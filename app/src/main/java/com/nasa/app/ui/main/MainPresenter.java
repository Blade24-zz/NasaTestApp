package com.nasa.app.ui.main;

import com.nasa.app.data.network.repositories.MainRepository;
import com.nasa.app.ui.base.BasePresenter;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

public class MainPresenter extends BasePresenter<MainView> {
    private MainRepository mMainRepository;

    @Inject
    public MainPresenter(final MainRepository _mainRepository) {
        this.mMainRepository = _mainRepository;
    }

    void loadRoverPhotosFromMars(){
        getView().showProgress();
        addDisposable(mMainRepository.getMarsRoversPhotos("curiosity", 1000, "fhaz")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(response -> {
                    if (!isViewAttached()) return;
                    getView().loadRoverPhotosSuccess(response.getPhotos());
                    getView().hideProgress();
                }, t -> {
                    if (!isViewAttached()) return;
                    Timber.e(t);
                    getView().hideProgress();
                    getView().showMessage(t.getMessage());
                }));
    }
}
