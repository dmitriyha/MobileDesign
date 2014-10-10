package fi.metropolia.healthquiz.classes;

import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dima on 10/9/2014.
 */
public class AnswerDataSource extends DataSource{

    private String[] allColumns = {"ID","QuestionID","Answer","Correct"};

    public AnswerDataSource(Context context){
        super(context);
    }

    @Override
    public AnswerObject getSingleObject(long row) {
        Cursor cursor=database.query(DatabaseAccessor.ANSWER, allColumns, null, null, null, null, null);
        cursor.move((int)row);

        AnswerObject answer=new AnswerObject();
        answer.setID(cursor.getLong(0));
        answer.setQuestionId(cursor.getLong(1));
        answer.setAnswer(cursor.getString(2));
        answer.setCorrect(cursor.getInt(3));

        return answer;
    }

    public List<AnswerObject> getAnswersByQuestion(long questionId){
        String queryArgs[]={String.valueOf(questionId)};
        Cursor cursor=database.rawQuery("select * from "+DatabaseAccessor.ANSWER+" where QuestionId= ?;",queryArgs);
        cursor.moveToFirst();
        List<AnswerObject> questionList = new ArrayList<AnswerObject>();
        while(!cursor.isAfterLast()){
            AnswerObject answer=new AnswerObject();
            answer.setID(cursor.getLong(0));
            answer.setQuestionId(cursor.getLong(1));
            answer.setAnswer(cursor.getString(2));
            answer.setCorrect(cursor.getInt(3));

            questionList.add(answer);
            cursor.moveToNext();
        }
        return questionList;
    }

    public List<AnswerObject> getAllData(){
        Cursor cursor=database.query(DatabaseAccessor.ANSWER, allColumns, null, null, null, null, null);
        cursor.moveToFirst();
        List<AnswerObject> questionList = new ArrayList<AnswerObject>();
        while(!cursor.isAfterLast()){
            AnswerObject answer=new AnswerObject();
            answer.setID(cursor.getLong(0));
            answer.setQuestionId(cursor.getLong(1));
            answer.setAnswer(cursor.getString(2));
            answer.setCorrect(cursor.getInt(3));

            questionList.add(answer);
            cursor.moveToNext();
        }
        return questionList;
    }
}
