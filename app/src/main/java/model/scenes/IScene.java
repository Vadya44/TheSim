package model.scenes;

import android.graphics.Canvas;
/**
 * Created by Vadya on 23.06.17.
 */

public interface IScene {
    void show();
    void hide();
    void justTap(float x, float y);
    void movedTouch(float x1, float y1, float x2, float y2);
    void onDraw(Canvas canvas);
}
