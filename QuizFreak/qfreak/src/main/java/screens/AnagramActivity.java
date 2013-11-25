package screens;

import android.content.Intent;
import android.os.Bundle;

import input.fragments.GameInputAnagramFragment;

public class AnagramActivity extends GenericGameActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void beforeOnCreate() {
        super.beforeOnCreate();
        this.inputFragment = new GameInputAnagramFragment();
    }

    @Override
    public void parseIntent(Intent intent) {
        super.parseIntent(intent);

    }
}
