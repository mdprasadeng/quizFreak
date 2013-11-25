package screens;

import input.fragments.GameInputHangmanFragment;

public class HangmanActivity extends GenericGameActivity {

    @Override
    public void beforeOnCreate() {
        super.beforeOnCreate();
        this.inputFragment = new GameInputHangmanFragment();
    }
}
