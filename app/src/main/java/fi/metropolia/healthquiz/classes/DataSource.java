package fi.metropolia.healthquiz.classes;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Dima on 10/9/2014.
 */
public abstract class DataSource {

    protected SQLiteDatabase database;
    protected DatabaseAccessor db;

    public DataSource (Context context){
        db= new DatabaseAccessor(context);
    }

    public abstract DatabaseObject getSingleObject(long row);

    public void open() throws SQLException {
        database=db.getReadableDatabase();
    }

    public void close(){
        db.close();
    }

}
