package fi.metropolia.healthquiz.customui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;

import fi.metropolia.healthquiz.model.AnswerObject;

/**
 * Created by Matti on 25.10.2014.
 */
public class AnswerButton extends Button {

    private AnswerObject answer;

    public AnswerButton(Context context) {
        super(context);
    }

    public AnswerButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AnswerButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }


    public AnswerObject getAnswer() {
        return answer;
    }

    public void setAnswer(AnswerObject answer) {
        this.answer = answer;
        this.setText(answer.getAnswer());
    }

}
