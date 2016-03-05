package com.khmelenko.lab.sensorsclient.di.module;

import com.khmelenko.lab.sensorsclient.network.RestClient;
import com.khmelenko.lab.sensorsclient.ui.presenter.DevicesActivityPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Presenter module
 *
 * @author Dmytro Khmelenko (d.khmelenko@gmail.com)
 */
@Module
public class PresenterModule {

    @Provides
    DevicesActivityPresenter providesMainActivityPresenter(RestClient restClient) {
        return new DevicesActivityPresenter(restClient);
    }

}
