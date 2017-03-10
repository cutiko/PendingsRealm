package cl.cutiko.pendingsrealm.models;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by cutiko on 10-03-17.
 */

public class Pending extends RealmObject {

    @PrimaryKey
    private long id;
    private String name;
    private boolean done;

    public Pending() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
