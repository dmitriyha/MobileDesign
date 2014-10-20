package fi.metropolia.healthquiz.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.List;

import fi.metropolia.healthquiz.R;
import fi.metropolia.healthquiz.model.QuestionGroupDataSource;
import fi.metropolia.healthquiz.model.QuestionGroupObject;

public class QuestionGroupSelection extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_group_selection);

        generateGroupSelectionButtons();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.question_group_selection, menu);
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


    private void generateGroupSelectionButtons() {
        Button button;

        // Get all groups
        QuestionGroupDataSource questionGroupDataSource = new QuestionGroupDataSource(this);
        List<QuestionGroupObject> questionGroupObjectList = questionGroupDataSource.getAllData();

        LinearLayout buttonContainer = (LinearLayout) findViewById(R.id.questions_group_selection_buttons);

        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        for (final QuestionGroupObject groupObject : questionGroupObjectList) {
            button = new Button(this);
            button.setText(groupObject.getName());

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    // Change the Activity to the question Activity if the user selects a group
                    Intent intent = new Intent(QuestionGroupSelection.this, Question.class);

                    Bundle bundle = new Bundle();
                    bundle.putLong("selected_question_group", groupObject.getID());
                    intent.putExtras(bundle);

                    startActivity(intent);
                }
            });

            buttonContainer.addView(button, lp);
        }
    }
}
