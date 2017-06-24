package model.scenes;
import android.app.Application;
import android.graphics.*;
import android.os.CountDownTimer;
import android.view.animation.*;

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
        final Animation fadeIn = new AlphaAnimation(1, 0);
        fadeIn.setInterpolator(new DecelerateInterpolator()); //add this
        fadeIn.setDuration(1000);
        new CountDownTimer(3000, 2000) {
            public void onFinish() {
                view.clearAnimation();
                hide();
            }

            public void onTick(long millisUntilFinished)
            {
                if (millisUntilFinished  <= 1000)
                    view.startAnimation(fadeIn);
            }
        }.start();
    }
    public void hide()
    {
        view.activeScene = menuSc;
        menuSc.show();
        menuSc = null;
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
