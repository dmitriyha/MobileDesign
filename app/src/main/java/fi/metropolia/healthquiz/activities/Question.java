package fi.metropolia.healthquiz.activities;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.sql.SQLException;
import java.util.List;
import java.util.Random;

import fi.metropolia.healthquiz.R;
import fi.metropolia.healthquiz.customui.AnswerButton;
import fi.metropolia.healthquiz.model.AnswerDataSource;
import fi.metropolia.healthquiz.model.AnswerObject;
import fi.metropolia.healthquiz.model.QuestionDataSource;
import fi.metropolia.healthquiz.model.QuestionObject;

public class Question extends Activity implements View.OnClickListener {

    private static String TAG = QuestionGroupSelection.class.getCanonicalName();
    TextView questionTextView;
    LinearLayout answerButtonContainer;
    TextView pointsTextView;
    QuestionDataSource questionDataSource;
    AnswerDataSource answerDataSource;
    private long questionGroup;
    private long points;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        questionGroup = getIntent().getExtras().getLong("selected_question_group");

        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey("points")) {
                points = savedInstanceState.getLong("points");
            }
        } else {
            points = 0;
        }

        questionTextView = (TextView) findViewById(R.id.question);
        answerButtonContainer = (LinearLayout) findViewById(R.id.answerButtonContainer);
        pointsTextView = (TextView) findViewById(R.id.points);

        questionDataSource = new QuestionDataSource(this);
        answerDataSource = new AnswerDataSource(this);

        try {
            questionDataSource.open();
            answerDataSource.open();
        } catch (SQLException e) {
            Log.i(TAG, e.getMessage().toString());
            e.printStackTrace();
        }

        updatePoints();
        setupNewQuestion();


    }


    private void setupNewQuestion() {

        List<QuestionObject> questionGroupObjectList = questionDataSource.getQuestionByGroup(questionGroup);

        Random random = new Random();

        QuestionObject question = questionGroupObjectList.get(random.nextInt(questionGroupObjectList.size()));

        questionTextView.setText(question.getQuestion());

        List<AnswerObject> answers = answerDataSource.getAnswersByQuestion(question.getID());

        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        answerButtonContainer.removeAllViews();

        for (AnswerObject answer : answers) {

            //Button button = new Button(this);
            //answerButtonContainer.addView(button);

            AnswerButton answerButton = new AnswerButton(this, answer, null);
            answerButton.setOnClickListener(this);

            answerButtonContainer.addView(answerButton, lp);


        }
    }

    @Override
    public void onClick(View view) {

        AnswerButton answerButton = (AnswerButton) view;

        if (answerButton != null) {
            if (answerButton.getAnswer().isCorrect()) {

                points += 100;
                updatePoints();

                // TODO check if there is more questions remaining

                setupNewQuestion();

            } else {
                // TODO minus one life point
            }
        }

    }

    private void updatePoints() {
        pointsTextView.setText(Long.toString(points));
    }


}
