package fi.metropolia.healthquiz.model;

/**
 * Created by Dima on 10/9/2014.
 */
public abstract class DatabaseObject {
    protected long ID;

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }
}
