package cl.cutiko.pendingsrealm;

import android.os.AsyncTask;
import android.util.Log;

import cl.cutiko.pendingsrealm.models.Pending;
import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by cutiko on 10-03-17.
 */

public class CreatePending extends AsyncTask<Pending, Integer, Pending> {

    @Override
    protected Pending doInBackground(Pending... params) {
        Realm realm = Realm.getDefaultInstance();
        RealmResults<Pending> pendings = realm.where(Pending.class).findAllSorted("id");
        long id = 1;
        if (pendings != null && pendings.size() > 0) {
            id = pendings.last().getId() + 1;
        }
        Log.d("ID", String.valueOf(id));
        realm.beginTransaction();
        Pending pending = params[0];
        pending.setId(id);
        Pending realmPending = realm.copyToRealm(pending);
        realm.commitTransaction();
        return realmPending;
    }


}
