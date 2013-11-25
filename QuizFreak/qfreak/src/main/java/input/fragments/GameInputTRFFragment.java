package input.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.durga.qfreak.R;

/**
 * Created by Durga on 24/11/13.
 */
public class GameInputTRFFragment extends GameInputGenericFragment implements View.OnClickListener {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_game_input_trf, container, false);
        rootView.findViewById(R.id.input_true).setOnClickListener(this);
        rootView.findViewById(R.id.input_false).setOnClickListener(this);
        rootView.findViewById(R.id.input_true).setTag("btn");
        rootView.findViewById(R.id.input_false).setTag("btn");
        return rootView;
    }

    @Override
    public void onClick(View view) {
        Button btn = (Button) view.findViewWithTag("btn");
        String str = btn.getText().toString();
        this.app.workingAnswer = str.toCharArray();
        this.done();
    }
}