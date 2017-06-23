package model.scenes;
import android.graphics.*;
import java.util.*;
import android.content.res.Resources;

/**
 * Created by Vadya on 23.06.17.
 * Scene of introducing to Game
 * Shows first 2 seconds
 * then continue to main menu
 */

public final class IntroScene extends Scene{

    private static Bitmap mbitmap;
    public void onDraw(Canvas canvas)
    {
        canvas.drawColor(Color.WHITE);
        //canvas.drawBitmap(mbitmap, 0,
          //      (int)(GameView.mainHidth * 0.2 * GameView.Factor), null);
    }
    public void show()
    {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {};

    }
    public void hide()
    {

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
