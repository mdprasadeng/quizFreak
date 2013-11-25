package input.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import screens.GenericGameActivity;
import com.durga.qfreak.R;

/**
 * Created by Durga on 24/11/13.
 */
public class GameInputMCQFragment extends GameInputGenericFragment implements View.OnClickListener{

    public GenericGameActivity activity;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_game_input_mcq, container, false);
        this.setOption(rootView, R.id.optionA, this.app.currQues.options[0]);
        this.setOption(rootView, R.id.optionB, this.app.currQues.options[1]);
        this.setOption(rootView, R.id.optionC, this.app.currQues.options[2]);
        this.setOption(rootView, R.id.optionD, this.app.currQues.options[3]);
        return rootView;
    }

    private void setOption(View rootView, int id, String text) {
        Button btn = (Button)(rootView.findViewById(id));
        btn.setText(text);
        btn.setTag("btn");
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Button btn = (Button) view.findViewWithTag("btn");
        String str = btn.getText().toString();
        this.app.workingAnswer = str.toCharArray();
        this.done();
    }
}