package fi.metropolia.healthquiz.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import fi.metropolia.healthquiz.R;


public class MainMenu extends Activity {

    private boolean continueGameAvailable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainmenu);


        // TODO Add the saved instance state shiat
        if (savedInstanceState.containsKey("continue")) {
            Button continueGameButton = (Button) findViewById(R.id.continue_game_buttton);
            continueGameButton.setVisibility(View.VISIBLE);
            continueGameAvailable = true;
        } else {
            continueGameAvailable = false;
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

    public void gameSelectionButtonClick(View view) {
        Intent intent = new Intent(MainMenu.this, QuestionGroupSelection.class);

        if (continueGameAvailable && (view.getId() == R.id.continue_game_buttton)) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("continue", true);
            intent.putExtras(bundle);
        }

        startActivity(intent);
    }
}



