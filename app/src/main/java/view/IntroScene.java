package view;
import android.graphics.*;
import android.os.CountDownTimer;
import android.view.animation.*;

import model.scenes.Scene;
import vadyaproduction.sim.GameView;

/**
 * Created by Vadya on 23.06.17.
 * Scene of introducing to Game
 * Shows first 3 seconds
 * then continue to main menu
 */

public final class IntroScene extends Scene {
    private GameView view;
    private MenuScene menuSc;
    private static Bitmap mbitmap;
    public IntroScene(Bitmap bitmap, GameView view, MenuScene menuSc)
    {
        this.view = view;
        this.menuSc = menuSc;
        mbitmap = bitmap;
        show();

    }
    @Override
    public void onDraw(Canvas canvas)
    {
        canvas.drawBitmap(mbitmap, 0 ,0 , null);
    }
    @Override
    public void show()
    {
        view.activeScene = this;
        final Animation fadeIn = new AlphaAnimation(1, 0);
        fadeIn.setInterpolator(new DecelerateInterpolator());
        fadeIn.setDuration(1000);
        new CountDownTimer(3000, 1000) {
            public void onFinish() {
                hide();
            }

            public void onTick(long millisUntilFinished)
            {
                if (millisUntilFinished  <= 1000) {
                    view.startAnimation(fadeIn);
                    view.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            final Animation fadeOut = new AlphaAnimation(0, 1);
                            fadeOut.setInterpolator(new AccelerateInterpolator()); //and this
                            fadeOut.setDuration(1000);
                            view.startAnimation(fadeOut);
                        }
                    }, 1000);
                }
            }
        }.start();
    }
    @Override
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
