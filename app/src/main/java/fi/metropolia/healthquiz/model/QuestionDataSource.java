package fi.metropolia.healthquiz.model;

import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dima on 10/9/2014.
 */
public class QuestionDataSource extends DataSource {

    private String[] allColumns = {"ID", "QuestionGroupID", "HasPicture", "Question"};

    public QuestionDataSource(Context context) {
        super(context);
    }

    @Override
    public QuestionObject getSingleObject(long row) {
        Cursor cursor = database.query(DatabaseAccessor.QUESTION, allColumns, null, null, null, null, null);
        cursor.move((int) row);

        QuestionObject question = new QuestionObject();
        question.setID(cursor.getLong(0));
        question.setQuestionGroupId(cursor.getLong(1));
        question.setHasPictures(cursor.getInt(2));
        question.setQuestion(cursor.getString(3));
        question.setAnswered(cursor.getInt(4));

        return question;
    }

    public QuestionObject getQuestionByID(long id) {

        String queryArgs[] = {String.valueOf(id)};
        Cursor cursor = database.rawQuery("select * from " + DatabaseAccessor.QUESTION + " where Id= ?;", queryArgs);
        cursor.moveToFirst();

        QuestionObject question = new QuestionObject();
        question.setID(cursor.getLong(0));
        question.setQuestionGroupId(cursor.getLong(1));
        question.setHasPictures(cursor.getInt(2));
        question.setQuestion(cursor.getString(3));

        return question;
    }

    public List<QuestionObject> getQuestionByGroup(long questionGroupId) {
        String queryArgs[] = {String.valueOf(questionGroupId)};
        Cursor cursor = database.rawQuery("select * from " + DatabaseAccessor.QUESTION + " where QuestionGroupId= ?;", queryArgs);
        cursor.moveToFirst();
        List<QuestionObject> questionList = new ArrayList<QuestionObject>();
        while (!cursor.isAfterLast()) {
            QuestionObject question = new QuestionObject();
            question.setID(cursor.getLong(0));
            question.setQuestionGroupId(cursor.getLong(1));
            question.setHasPictures(cursor.getInt(2));
            question.setQuestion(cursor.getString(3));

            questionList.add(question);
            cursor.moveToNext();
        }
        return questionList;
    }

    public List<QuestionObject> getAllData() {
        Cursor cursor = database.query(DatabaseAccessor.QUESTION, allColumns, null, null, null, null, null);
        cursor.moveToFirst();
        List<QuestionObject> questionList = new ArrayList<QuestionObject>();
        while (!cursor.isAfterLast()) {
            QuestionObject question = new QuestionObject();
            question.setID(cursor.getLong(0));
            question.setQuestionGroupId(cursor.getLong(1));
            question.setHasPictures(cursor.getInt(2));
            question.setQuestion(cursor.getString(3));
            question.setAnswered(cursor.getInt(4));

            questionList.add(question);
            cursor.moveToNext();
        }
        return questionList;
    }
}
