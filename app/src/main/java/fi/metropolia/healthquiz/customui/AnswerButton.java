package fi.metropolia.healthquiz.customui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.ToggleButton;

import fi.metropolia.healthquiz.model.AnswerObject;

/**
 * Created by Matti on 25.10.2014.
 */
public class AnswerButton extends Button {

    private AnswerObject answer;

    public AnswerButton(Context context, AnswerObject answer, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.answer = answer;
        setupButton();
    }

    public AnswerButton(Context context, AnswerObject answer, AttributeSet attrs) {
        super(context, attrs);
        this.answer = answer;
        setupButton();
    }

    public AnswerButton(Context context, AnswerObject answer) {
        super(context);
        this.answer = answer;

        setupButton();
    }

    private void setupButton() {

        this.setText(answer.getAnswer());
    }

}
