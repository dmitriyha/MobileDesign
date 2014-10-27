package fi.metropolia.healthquiz.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.sql.SQLException;

import fi.metropolia.healthquiz.R;
import fi.metropolia.healthquiz.model.QuestionDataSource;

public class Score extends Activity {

    private static String TAG = Score.class.getCanonicalName();

    private long questionGroupID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        TextView scoreTextView = (TextView) findViewById(R.id.points);
        scoreTextView.setText(Long.toString(getIntent().getExtras().getLong("points")));

        TextView stateTextView = (TextView) findViewById(R.id.stateTextView);
        FinalGameState state = (FinalGameState) getIntent().getExtras().getSerializable("state");

        switch (state) {
            case ALL_QUESTIONS_ANSWERED:
                stateTextView.setText(getResources().getString(R.string.score_all_questions_answered));
                break;

            case NO_LIVES_LEFT:
                stateTextView.setText(getResources().getString(R.string.score_no_lives_left));
                break;
        }

        questionGroupID = getIntent().getExtras().getLong("questionGroupID");
    }

    public void returnToMenu(View view) {
        Intent intent = new Intent(Score.this, MainMenu.class);
        startActivity(intent);
    }

    public void replay(View view) {
        // Change the Activity to the question Activity if the user selects a group
        Intent intent = new Intent(Score.this, Question.class);

        Bundle bundle = new Bundle();
        bundle.putLong("questionGroupID", questionGroupID);
        intent.putExtras(bundle);

        QuestionDataSource questionDataSource = new QuestionDataSource(this);

        try {
            questionDataSource.open();
        } catch (SQLException e) {
            Log.i(TAG, e.getMessage().toString());
            e.printStackTrace();
        }

        questionDataSource.resetAnsweredQuestions();

        startActivity(intent);
    }
}
