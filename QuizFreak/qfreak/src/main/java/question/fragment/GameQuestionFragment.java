package question.fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.durga.qfreak.R;

import com.durga.qfreak.GameLogicEngine;
import screens.GenericGameActivity;

/**
 * Created by Durga on 24/11/13.
 */
public class GameQuestionFragment extends Fragment {

    public GenericGameActivity activity;
    private GameLogicEngine app;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.app = (GameLogicEngine)this.getActivity().getApplication();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_game_question, container, false);
        TextView textView = (TextView) rootView.findViewById(R.id.game_question);
        textView.setText(this.app.currQues.question);
        return rootView;
    }
}