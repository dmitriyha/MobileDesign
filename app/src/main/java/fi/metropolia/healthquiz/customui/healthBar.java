package fi.metropolia.healthquiz.customui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;

import fi.metropolia.healthquiz.R;

/**
 * Created by Matti on 29.10.2014.
 */
public class HealthBar extends LinearLayout {

    private static int DEFAULT_MAX_HEALTH = 5;
    private static int ICON_RESOURCE_NAME = R.drawable.hearth_icon;

    private int health;

    public HealthBar(Context context) {
        super(context);
        setHealth(DEFAULT_MAX_HEALTH);
    }

    public HealthBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        setHealth(DEFAULT_MAX_HEALTH);
    }

    public HealthBar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setHealth(DEFAULT_MAX_HEALTH);
    }

    public boolean lifeLost() {
        setHealth(health - 1);
        return isAlive();
    }

    public boolean isAlive() {
        return !(this.health == 0);
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {

        if (health > DEFAULT_MAX_HEALTH) {
            this.health = DEFAULT_MAX_HEALTH;
        } else if (health < 0) {
            this.health = 0;
        } else {
            this.health = health;
        }

        redraw();

    }


    public void redraw() {
        this.removeAllViews();

        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(50, 50);

        for (int i = 0; i < health; i++) {
            ImageView imageView = new ImageView(this.getContext());
            imageView.setImageResource(ICON_RESOURCE_NAME);
            imageView.setMaxHeight(20);
            this.addView(imageView, lp);
        }
    }
}
