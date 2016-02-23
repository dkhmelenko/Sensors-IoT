package com.khmelenko.lab.sensorsclient.ui.presenter;

import com.khmelenko.lab.sensorsclient.network.RestClient;
import com.khmelenko.lab.sensorsclient.ui.view.MainActivityView;

import javax.inject.Inject;

/**
 * Implementation of the main activity presenter
 *
 * @author Dmytro Khmelenko (d.khmelenko@gmail.com)
 */
public class MainActivityPresenterImpl implements MainActivityPresenter {

    private MainActivityView mView;

    private final RestClient mRestClient;

    @Inject
    public MainActivityPresenterImpl(RestClient restClient) {
        mRestClient = restClient;
    }

    @Override
    public void onAttach() {

    }

    @Override
    public void onDettach() {

    }

    @Override
    public void registerView(MainActivityView view) {
        mView = view;
    }
}
