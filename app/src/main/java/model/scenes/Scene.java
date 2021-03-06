package model.scenes;
import android.graphics.Canvas;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;

import java.util.ArrayList;

import model.DrawableElement;
import model.buttons.Button;
import vadyaproduction.sim.GameView;

/**
 * Created by Vadya on 23.06.17.
 */

public class Scene {
    protected ArrayList<DrawableElement> drawableElements = new ArrayList<DrawableElement>();
    protected GameView view;

    public void show() {
        view.postDelayed(new Runnable() {
            @Override
            public void run() {
                final Animation fadeOut = new AlphaAnimation(0, 1);
                fadeOut.setInterpolator(new AccelerateInterpolator()); //and this
                fadeOut.setDuration(500);
                view.startAnimation(fadeOut);
            }
        }, 500);
    }

    public void hide(Scene scene) {
        final Animation fadeIn = new AlphaAnimation(1, 0);
        fadeIn.setInterpolator(new DecelerateInterpolator());
        fadeIn.setDuration(500);
        view.startAnimation(fadeIn);
        final Scene locScene = scene;
        view.postDelayed(new Runnable() {
            @Override
            public void run() {
                view.setActiveScene(locScene);
            }
        }, 500);
    }

    public void onDraw(Canvas canvas) {
        if (!drawableElements.isEmpty()) {
            for (DrawableElement ele : drawableElements)
                ele.onDraw(canvas);
        }

    }
    public void actionDOWN(float x, float y)
    {
        for (DrawableElement btn : drawableElements)
            if (btn instanceof Button) {
                if (((Button) btn).isThisButtonTap(x, y))
                    ((Button) btn).setWasClicked(true);
            }
            view.invalidate();
    }
    public void actionCancel()
    {
        for (DrawableElement btn : drawableElements)
            if (btn instanceof Button)
                ((Button)btn).setWasClicked(false);
        view.invalidate();
    }
    public void justTap(float x, float y) {
    }

    public void movedTouch(float x1, float y1, float x2, float y2) {
    }
}
