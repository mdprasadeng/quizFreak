package input.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import screens.GenericGameActivity;
import screens.MCQActivity;
import com.durga.qfreak.R;

/**
 * Created by Durga on 24/11/13.
 */
public class GameInputAnagramFragment extends GameInputGenericFragment implements View.OnClickListener {

    public GenericGameActivity activity;
    private View view;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.resetWorkingAnswer();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.view = inflater.inflate(R.layout.fragment_game_input_anagram, container, false);
        ((TextView)this.view.findViewById(R.id.working_answer)).setText(this.app.getDisplayWorkingAnswer());

        this.setupInput();
        return this.view;
    }

    private void setupInput() {
        LinearLayout layoutOne = (LinearLayout) view.findViewById(R.id.game_input_row_1);
        LinearLayout layoutTwo = (LinearLayout) view.findViewById(R.id.game_input_row_2);
        layoutOne.removeAllViews();
        layoutTwo.removeAllViews();
        String jumbled = this.app.currQues.options[0].toUpperCase();
        for (int i = 0; i < jumbled.length(); i++) {
            if(i > jumbled.length()/2) {
                layoutTwo.addView(this.getGenericButton(String.valueOf(jumbled.charAt(i))));
            }
            else {
                layoutOne.addView(this.getGenericButton(String.valueOf(jumbled.charAt(i))));
            }
        }
        layoutTwo.addView(this.getGenericButton("Clr"));
    }

    private Button getGenericButton( String ch) {
        Button btn = new Button(this.getActivity());
        btn.setText(ch);
        btn.setTag("btn");
        btn.setOnClickListener(this);
        btn.setLayoutParams(new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, 1));
        return btn;
    }


    @Override
    public void onClick(View view) {
        Button btn = (Button) view.findViewWithTag("btn");
        String str = btn.getText().toString();
        if(str.equals("Clr")) {
            this.resetWorkingAnswer();
            this.setupInput();
        }
        else{

            while(this.app.workingAnswer[this.app.workingOffset] != '_') {
                this.app.workingOffset++;
            }
            this.app.workingAnswer[this.app.workingOffset] = str.charAt(0);
            this.app.workingOffset++;
            btn.setEnabled(false);
        }
        ((TextView)this.view.findViewById(R.id.working_answer)).setText(this.app.getDisplayWorkingAnswer());
        if(this.app.workingOffset == this.app.currQues.answer.length()) {
            this.done();
        }
    }




    public void resetWorkingAnswer(){
        this.app.workingAnswer = new char[this.app.currQues.answer.length()];
        this.app.workingOffset = 0;
        for(int i=0; i < this.app.currQues.answer.length(); i++) {
            if(Character.isLetter(this.app.currQues.answer.charAt(i))) {
                this.app.workingAnswer[i] = '_';
            }
            else {
                this.app.workingAnswer[i] = this.app.currQues.answer.charAt(i);
            }
        }

    }
}