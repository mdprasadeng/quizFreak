package com.durga.qfreak;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;

import screens.AnagramActivity;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_template);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
//                    .add(R.id.game_question, new GameQuestionFragment())
//                    .add(R.id.game_input, new GameInputFragment())
                    .commit();
        }
        this.changeScreen();
    }

    public void changeScreen(){
        Intent intent = new Intent(this, AnagramActivity.class);
        startActivity(intent);
    }


}
