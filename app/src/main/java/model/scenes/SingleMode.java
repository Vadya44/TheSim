package model.scenes;

import android.graphics.Canvas;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;

import vadyaproduction.sim.GameView;

/**
 * Created by Vadya on 24.06.17.
 */

public final class SingleMode extends Scene {
    GameView view = null;
    @Override
    public void show() {
        final Animation fadeOut = new AlphaAnimation(0, 1);
        fadeOut.setInterpolator(new AccelerateInterpolator()); //and this
        fadeOut.setDuration(1000);
        view.startAnimation(fadeOut);
    }

    @Override
    public void hide() {

    }

    @Override
    public void onDraw(Canvas canvas) {

    }

    @Override
    public void justTap(float x, float y) {

    }

    @Override
    public void movedTouch(float x1, float y1, float x2, float y2) {

    }
}
