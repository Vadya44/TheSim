package model.scenes;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import model.controller.GestureHandler;
import model.scenes.IntroScene;
import model.scenes.MainMenu;
import model.scenes.Scene;
import vadyaproduction.sim.GameView;
import vadyaproduction.sim.R;
import android.view.animation.*;

/**
 * Created by Vadya on 24.06.17.
 */

public final class MainMenu extends Scene {

    private GameView view;
    private Bitmap mbitmap;
    public MainMenu(GameView view)
    {
        this.view = view;
        mbitmap= Bitmap.createScaledBitmap(BitmapFactory.decodeResource(view.res,
                R.drawable.menu), (int) (view.factor * view.mainWidth),
                (int) (view.factor * view.mainHidth), false);
    }
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

        canvas.drawBitmap(mbitmap, 0 ,0 , null);
    }

    @Override
    public void justTap(float x, float y) {

    }

    @Override
    public void movedTouch(float x1, float y1, float x2, float y2) {

    }
}
