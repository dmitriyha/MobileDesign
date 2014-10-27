package fi.metropolia.healthquiz.model;

import android.content.Context;

import java.sql.SQLException;

/**
 * Created by Dima on 10/9/2014.
 */
public class QuestionObject extends DatabaseObject {
    private long questionGroupId;
    private boolean hasPicture;
    private String question;
    private boolean answered;


    public long getQuestionGroupId() {
        return questionGroupId;
    }

    public void setQuestionGroupId(long questionGroupId) {
        this.questionGroupId = questionGroupId;
    }

    public boolean hasPicture() {
        return hasPicture;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public boolean isAnswered(){ return answered; }

    public void updateDB(Context context){
        QuestionDataSource question=new QuestionDataSource(context);
        try {
            question.open();
            question.updateQuestion(ID);
            question.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setHasPictures(int hasPicture) {
        if (hasPicture == 1) {
            this.hasPicture = true;
        } else if (hasPicture == 0) {
            this.hasPicture = false;
        } else {
            try {
                throw new Exception("not a boolean form of 1 or 0");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }



    public void setAnswered(int isAnswered) {
        if (isAnswered == 1) {
            answered = true;
        } else if (isAnswered == 0) {
            answered = false;
        } else {
            try {
                throw new Exception("not a boolean form of 1 or 0");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
