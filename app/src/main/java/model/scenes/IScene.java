package model.scenes;

import android.graphics.Canvas;
/**
 * Created by Vadya on 23.06.17.
 */

public interface IScene {
    void show();
    void hide();
    void justTap();
    void movedTouch();
    void onDraw(Canvas canvas);
}
