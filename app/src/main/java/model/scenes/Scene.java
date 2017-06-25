package model.scenes;
import android.graphics.Canvas;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;

import vadyaproduction.sim.GameView;

/**
 * Created by Vadya on 23.06.17.
 */

public class Scene implements IScene {
    protected GameView view;
    public void show() {
    }
    public void hide(){
        final Animation fadeIn = new AlphaAnimation(1, 0);
        fadeIn.setInterpolator(new DecelerateInterpolator());
        fadeIn.setDuration(600);
        view.startAnimation(fadeIn);

        view.postDelayed(new Runnable() {
            @Override
            public void run() {
                final Animation fadeOut = new AlphaAnimation(0, 1);
                fadeOut.setInterpolator(new AccelerateInterpolator()); //and this
                fadeOut.setDuration(600);
                view.startAnimation(fadeOut);
            }
        }, 600);
    }
    public void onDraw(Canvas canvas){

    }
    public void justTap(float x, float y){

    }
    public void movedTouch(float x1, float y1, float x2, float y2){

    }
}
