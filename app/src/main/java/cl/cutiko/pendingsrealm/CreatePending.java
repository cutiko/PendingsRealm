package cl.cutiko.pendingsrealm;

import android.os.AsyncTask;
import android.util.Log;

import cl.cutiko.pendingsrealm.models.Pending;
import io.realm.Realm;

/**
 * Created by cutiko on 10-03-17.
 */

public class CreatePending extends AsyncTask<Pending, Integer, Pending> {

    @Override
    protected Pending doInBackground(Pending... params) {
        Realm realm = Realm.getDefaultInstance();
        long id = System.currentTimeMillis();
        Log.d("ID", String.valueOf(id));
        realm.beginTransaction();
        Pending pending = params[0];
        pending.setId(id);
        Pending realmPending = realm.copyToRealm(pending);
        realm.commitTransaction();
        return realmPending;
    }


}
