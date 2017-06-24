package model.scenes;
import android.app.Application;
import android.graphics.*;
import android.content.Context;
import android.content.res.Resources;
import java.util.*;
import android.content.res.Resources;

import vadyaproduction.sim.GameView;

/**
 * Created by Vadya on 23.06.17.
 * Scene of introducing to Game
 * Shows first 2 seconds
 * then continue to main menu
 */

public final class IntroScene extends Scene{

    private GameView view = null;
    private MainMenu menuSc = null;
    private static Bitmap mbitmap;
    public IntroScene(Bitmap bitmap, GameView view, MainMenu menuSc)
    {
        this.view = view;
        this.menuSc = menuSc;
        mbitmap = bitmap;
        show();

    }
    public void onDraw(Canvas canvas)
    {
        canvas.drawBitmap(mbitmap, 0 ,0 , null);
    }
    public void show()
    {
        view.activeScene = this;

        hide();

    }
    public void hide()
    {
        view.activeScene = menuSc;
        view.invalidate();
    }
    /**
    Touch event's are don't working in this scene
     */
    public void movedTouch(float x1, float y1, float x2, float y2) {
        return;
    }
    public void justTap(float x, float y){
        return;
    }
}
