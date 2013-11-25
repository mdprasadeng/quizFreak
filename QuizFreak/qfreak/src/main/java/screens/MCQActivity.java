package screens;

import android.content.Intent;
import android.os.Bundle;

import input.fragments.GameInputMCQFragment;

public class MCQActivity extends GenericGameActivity {

    public String optionA;
    public String optionB;
    public String optionC;
    public String optionD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void beforeOnCreate() {
        super.beforeOnCreate();
        this.inputFragment = new GameInputMCQFragment();
    }

    @Override
    public void parseIntent(Intent intent) {
        super.parseIntent(intent);
    }
}