package fi.metropolia.healthquiz.model;

/**
 * Created by Dima on 10/9/2014.
 */
public class AnswerObject extends DatabaseObject {
    private long questionId;
    private String answer;
    private boolean correct;

    public long getQuestionId() {
        return questionId;
    }

    public String getAnswer() {
        return answer;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setQuestionId(long questionId) {
        this.questionId = questionId;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setCorrect(int correct) {
        if(correct==1){
            this.correct=true;
        }
        else if (correct==0){
            this.correct=false;
        }
        else{
            try {
                throw new Exception("not a boolean form of 1 or 0");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
