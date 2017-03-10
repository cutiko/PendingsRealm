package cl.cutiko.pendingsrealm.application;

import android.app.Application;

import io.realm.Realm;

/**
 * Created by cutiko on 10-03-17.
 */

public class RealmApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(getApplicationContext());
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}
