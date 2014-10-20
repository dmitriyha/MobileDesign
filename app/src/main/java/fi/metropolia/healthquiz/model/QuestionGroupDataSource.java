package fi.metropolia.healthquiz.model;

import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dima on 10/9/2014.
 */
public class QuestionGroupDataSource extends DataSource {


    private String[] allColumns = {"ID", "Name"};

    public QuestionGroupDataSource(Context context) {
        super(context);
    }

    @Override
    public QuestionGroupObject getSingleObject(long row) {
        Cursor cursor = database.query(DatabaseAccessor.QUESTION_GROUP, allColumns, null, null, null, null, null);
        cursor.move((int) row);

        QuestionGroupObject group = new QuestionGroupObject();
        group.setID(cursor.getLong(0));
        group.setName(cursor.getString(1));

        return group;
    }

    public List<QuestionGroupObject> getAllData() {
        Cursor cursor = database.query(DatabaseAccessor.QUESTION_GROUP, allColumns, null, null, null, null, null);
        cursor.moveToFirst();
        List<QuestionGroupObject> groupList = new ArrayList<QuestionGroupObject>();
        while (!cursor.isAfterLast()) {
            QuestionGroupObject group = new QuestionGroupObject();
            group.setID(cursor.getLong(0));
            group.setName(cursor.getString(1));
            groupList.add(group);
            cursor.moveToNext();
        }
        return groupList;
    }

}
