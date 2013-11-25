package screens;

import input.fragments.GameInputTRFFragment;

public class TRFActivity extends GenericGameActivity {

    @Override
    public void beforeOnCreate() {
        super.beforeOnCreate();
        this.inputFragment = new GameInputTRFFragment();
    }

}
