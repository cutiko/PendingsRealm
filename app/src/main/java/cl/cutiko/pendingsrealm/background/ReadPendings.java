package cl.cutiko.pendingsrealm.background;

import android.os.AsyncTask;
import android.util.Log;

import cl.cutiko.pendingsrealm.models.Pending;
import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by cutiko on 14-03-17.
 */

public class ReadPendings extends AsyncTask<Void, Integer, String> {
    @Override
    protected String doInBackground(Void... params) {
        long start = System.currentTimeMillis();
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        RealmResults<Pending> realmPendings = realm.where(Pending.class).findAll();
        Log.d("READS", String.valueOf(realmPendings.size()));
        realm.close();
        long end = System.currentTimeMillis();
        long diff = end-start;

        return "Tomó " + diff + " milisegundo leer 10000 inserciones";
    }
}
