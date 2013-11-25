package input.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.durga.qfreak.R;

/**
 * Created by Durga on 24/11/13.
 */
public class GameInputHangmanFragment extends GameInputGenericFragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_game_input_hangman, container, false);
        return rootView;
    }
}