package cl.cutiko.pendingsrealm.views;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import cl.cutiko.pendingsrealm.R;
import cl.cutiko.pendingsrealm.models.Pending;
import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
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
        });

        setPendingListener();

    }

    private void setPendingListener() {
        Realm realm = Realm.getDefaultInstance();
        RealmResults<Pending> pendings = realm.where(Pending.class).findAll();
        pendings.addChangeListener(new RealmChangeListener<RealmResults<Pending>>() {
            @Override
            public void onChange(RealmResults<Pending> element) {
                Pending pending = element.get(element.size()-1);
                Log.d("PENDING", pending.getName());
            }
        });
    }


}
