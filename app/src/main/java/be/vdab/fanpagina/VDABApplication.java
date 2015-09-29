package be.vdab.fanpagina;

import android.app.Application;

import be.vdab.fanpagina.BuildConfig;
import timber.log.Timber;

public class VDABApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }

}