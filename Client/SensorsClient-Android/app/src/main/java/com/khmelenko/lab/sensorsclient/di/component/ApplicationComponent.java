package com.khmelenko.lab.sensorsclient.di.component;

import com.khmelenko.lab.sensorsclient.SensorsApp;
import com.khmelenko.lab.sensorsclient.di.module.ApplicationModule;
import com.khmelenko.lab.sensorsclient.di.module.NetworkModule;
import com.khmelenko.lab.sensorsclient.network.RestClient;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Application component
 *
 * @author Dmytro Khmelenko (d.khmelenko@gmail.com)
 */
@Singleton
@Component(modules = {ApplicationModule.class, NetworkModule.class})
public interface ApplicationComponent {
    void inject(SensorsApp app);

    RestClient restClient();
}
