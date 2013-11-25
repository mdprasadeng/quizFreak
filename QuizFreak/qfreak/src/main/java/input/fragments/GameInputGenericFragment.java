package input.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.durga.qfreak.GameLogicEngine;

/**
 * Created by Durga on 24/11/13.
 */
public abstract class GameInputGenericFragment extends Fragment {

    public GameLogicEngine app;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.app = (GameLogicEngine) this.getActivity().getApplication();
    }

    public void done() {
        startActivity(new Intent(this.getActivity(), this.app.getNextQuestion()));
    }
}