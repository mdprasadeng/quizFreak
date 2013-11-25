package screens;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;

import question.fragment.GameQuestionFragment;
import com.durga.qfreak.R;

import com.durga.qfreak.GameLogicEngine;

public abstract class GenericGameActivity extends ActionBarActivity {


    protected Fragment questionFragment;
    protected Fragment inputFragment;
    protected GameLogicEngine app;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.parseIntent(getIntent());
        this.beforeOnCreate();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_template);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.game_question_frame, this.questionFragment)
                    .add(R.id.game_input_frame, this.inputFragment)
                    .commit();
        }
        this.app = (GameLogicEngine) this.getApplication();
    }

    protected void parseIntent(Intent intent) {
    }
    public void beforeOnCreate(){
        this.questionFragment = new GameQuestionFragment();
    };

}
