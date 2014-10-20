package fi.metropolia.healthquiz.model;

/**
 * Created by Dima on 10/9/2014.
 */
public class QuestionObject extends DatabaseObject{
    private long questionGroupId;
    private boolean hasPicture;
    private String question;



    public long getQuestionGroupId() {
        return questionGroupId;
    }

    public boolean hasPicture() {
        return hasPicture;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestionGroupId(long questionGroupId) {
        this.questionGroupId = questionGroupId;
    }

    public void setHasPictures(int hasPicture) {
        if(hasPicture==1){
            this.hasPicture=true;
        }
        else if (hasPicture==0){
            this.hasPicture=false;
        }
        else{
            try {
                throw new Exception("not a boolean form of 1 or 0");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
