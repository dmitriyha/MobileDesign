package fi.metropolia.healthquiz.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fi.metropolia.healthquiz.R;
import fi.metropolia.healthquiz.classes.AnswerDataSource;
import fi.metropolia.healthquiz.classes.AnswerObject;
import fi.metropolia.healthquiz.classes.QuestionDataSource;
import fi.metropolia.healthquiz.classes.QuestionGroupDataSource;
import fi.metropolia.healthquiz.classes.QuestionGroupObject;
import fi.metropolia.healthquiz.classes.QuestionObject;


public class MainMenu extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainmenu);

        QuestionGroupDataSource group = new QuestionGroupDataSource(this);
        try {
            group.open();

            List<QuestionGroupObject> groupList=group.getAllData();
            QuestionGroupObject groupObject=groupList.get(0);
            System.out.println(groupObject.getName());

            group.close();

            QuestionDataSource question= new QuestionDataSource(this);
            question.open();

            List<QuestionObject> questionList= question.getQuestionByGroup(groupObject.getID());
            QuestionObject questionObject=questionList.get(0);
            System.out.println(questionObject.getQuestion());

            question.close();

            AnswerDataSource answer=new AnswerDataSource(this);
            answer.open();

            List<AnswerObject> answerList=answer.getAnswersByQuestion(questionObject.getID());
            AnswerObject answerObject=answerList.get(0);
            System.out.println(answerObject.getAnswer());
            answer.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.intro, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
