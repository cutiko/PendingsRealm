package cl.cutiko.pendingsrealm.views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.Toast;

import cl.cutiko.pendingsrealm.CreatePending;
import cl.cutiko.pendingsrealm.R;

public class MainActivity extends AppCompatActivity {

    /*private Realm realm;
    private RealmResults<Pending> realmPendings;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                Fragment prev = getSupportFragmentManager().findFragmentByTag("createPending");
                if (prev != null) {
                    ft.remove(prev);
                }
                ft.addToBackStack(null);

                DialogFragment dialogFragment = CreatePendingDialogFragment.newInstance();
                dialogFragment.show(ft, "createPending");
            }
        });*/

        //setRealm();

        new BulkCreation().execute();
    }

    private void setRealm() {
        /*realm = Realm.getDefaultInstance();
        realmPendings = realm.where(Pending.class).equalTo("done", false).findAll();
        Log.d("SIZE", "There are " + realmPendings.size() + " out of " + realm.where(Pending.class).findAll().size() + " pendings done");
        RealmChangeListener<RealmResults<Pending>> realmChangeListener = new RealmChangeListener<RealmResults<Pending>>() {
            @Override
            public void onChange(RealmResults<Pending> element) {
                Toast.makeText(MainActivity.this, element.last().getName(), Toast.LENGTH_SHORT).show();
            }
        };
        realmPendings.addChangeListener(realmChangeListener);
        PendingsAdapter pendingsAdapter = new PendingsAdapter(realmPendings);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.pendingsRv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(pendingsAdapter);*/
    }


    @Override
    protected void onStop() {
        super.onStop();
        /*realm.close();
        realmPendings.removeAllChangeListeners();*/
    }

    private class BulkCreation extends CreatePending {

        @Override
        protected void onPostExecute(String s) {
            Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
            Log.d("BULK_INSER", s);
        }
    }
}
