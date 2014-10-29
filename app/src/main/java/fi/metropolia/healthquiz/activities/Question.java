package fi.metropolia.healthquiz.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import fi.metropolia.healthquiz.R;
import fi.metropolia.healthquiz.customui.AnswerButton;
import fi.metropolia.healthquiz.customui.HealthBar;
import fi.metropolia.healthquiz.model.AnswerDataSource;
import fi.metropolia.healthquiz.model.AnswerObject;
import fi.metropolia.healthquiz.model.QuestionDataSource;
import fi.metropolia.healthquiz.model.QuestionObject;

public class Question extends Activity implements View.OnClickListener {


    private static int MAX_LIVES = 5;
    private static String TAG = QuestionGroupSelection.class.getCanonicalName();


    TextView questionTextView;
    LinearLayout answerButtonContainer;
    TextView pointsTextView;
    HealthBar healthBar;

    QuestionDataSource questionDataSource;
    AnswerDataSource answerDataSource;

    private long questionGroupID;
    private long points;
    private long currentQuestionID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        questionDataSource = new QuestionDataSource(this);
        answerDataSource = new AnswerDataSource(this);

        try {
            questionDataSource.open();
            answerDataSource.open();
        } catch (SQLException e) {
            Log.i(TAG, e.getMessage().toString());
            e.printStackTrace();
        }

        // Find views
        questionTextView = (TextView) findViewById(R.id.question);
        answerButtonContainer = (LinearLayout) findViewById(R.id.answerButtonContainer);
        pointsTextView = (TextView) findViewById(R.id.points);
        healthBar = (HealthBar) findViewById(R.id.healthBar);

        if (savedInstanceState != null) {

            // Restore points
            if (savedInstanceState.containsKey("points")) {
                points = savedInstanceState.getLong("points");
            }

            // Restore question
            if (savedInstanceState.containsKey("questionID")) {
                setupKnownQuestion(savedInstanceState.getLong("questionID"));
            }

            // Restore question group
            if (savedInstanceState.containsKey("questionGroupID")) {
                questionGroupID = savedInstanceState.getLong("questionGroupID");
            }

            // Restore lives
            if (savedInstanceState.containsKey("lives")) {
                healthBar.setHealth(savedInstanceState.getInt("lives"));
            }

        } else {
            questionGroupID = getIntent().getExtras().getLong("questionGroupID");
            setupNewRandomQuestion();
            points = 0L;
        }

        updatePoints();
    }


    private void setupNewRandomQuestion() {

        List<QuestionObject> questionGroupObjectList = questionDataSource.getQuestionByGroup(questionGroupID);

        Random random = new Random();

        QuestionObject question = questionGroupObjectList.get(random.nextInt(questionGroupObjectList.size()));

        setupQuestion(question);

    }

    private void setupKnownQuestion(long questionID) {
        QuestionObject question = questionDataSource.getQuestionByID(questionID);

        setupQuestion(question);
    }


    private void setupQuestion(QuestionObject question) {

        currentQuestionID = question.getID();

        questionTextView.setText(question.getQuestion());

        List<AnswerObject> answers = answerDataSource.getAnswersByQuestion(question.getID());

        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        answerButtonContainer.removeAllViews();

        Collections.shuffle(answers, new Random());

        for (AnswerObject answer : answers) {

            AnswerButton answerButton = new AnswerButton(this, answer, null);
            answerButton.setBackgroundResource(R.drawable.question_button);
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

            } else {

                // If out of lives then change to end screen
                if (!healthBar.lifeLost()) {
                    switchToScoreScreen(FinalGameState.NO_LIVES_LEFT);
                }
            }

            questionDataSource.updateQuestion(currentQuestionID);

            Log.d(TAG, "Unanswered questions remaining: " + questionDataSource.getQuestionByGroup(questionGroupID).size());

            if (questionDataSource.getQuestionByGroup(questionGroupID).isEmpty()) {
                switchToScoreScreen(FinalGameState.ALL_QUESTIONS_ANSWERED);
            } else {
                setupNewRandomQuestion();
            }
        }
    }

    private void updatePoints() {
        pointsTextView.setText(Long.toString(points));
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putLong("points", points);
        outState.putLong("questionID", currentQuestionID);
        outState.putLong("questionGroupID", questionGroupID);
        outState.putInt("lives", healthBar.getHealth());
    }

    private void switchToScoreScreen(FinalGameState state) {
        Intent intent = new Intent(Question.this, Score.class);

        Bundle bundle = new Bundle();
        bundle.putLong("points", points);
        bundle.putLong("questionGroupID", questionGroupID);
        bundle.putSerializable("state", state);
        intent.putExtras(bundle);

        startActivity(intent);
    }

}
