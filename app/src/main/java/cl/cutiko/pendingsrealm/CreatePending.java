package cl.cutiko.pendingsrealm;

import android.os.AsyncTask;
import android.util.Log;

import cl.cutiko.pendingsrealm.models.Pending;
import io.realm.Realm;

/**
 * Created by cutiko on 10-03-17.
 */

//Changing this method to test bulk transactions
public class CreatePending extends AsyncTask<Void, Integer, String> {

    private static final int INSERTIONS = 10000;

    @Override
    protected String doInBackground(Void... params) {
        long start = System.currentTimeMillis();
        Realm realm = Realm.getDefaultInstance();
        for (int i = 0; i < INSERTIONS; i++) {
            Pending pending = new Pending(i, String.valueOf(i), false);
            realm.beginTransaction();
            realm.copyToRealm(pending);
            realm.commitTransaction();
            if (i%100==0) {
                Log.d("INSERTION", String.valueOf(i));
            }
        }
        realm.close();
        long end = System.currentTimeMillis();

        long diff = end - start;
        if (diff >= 1000) {
            diff = diff/1000;
            return resultFormat(diff + " ");
        } else {
            return resultFormat(diff + "mili");
        }
    }

    private String resultFormat(String diff) {
        return "Hacer " + INSERTIONS + " inserciones tomó " + diff + "segundos";
    }
}
