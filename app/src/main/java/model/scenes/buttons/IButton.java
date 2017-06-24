package model.scenes.buttons;

import android.graphics.Canvas;

/**
 * Created by Vadya on 25.06.17.
 */

public abstract class IButton {
    float x1, y1 ,x2, y2;
    public abstract boolean isThisButtonTap(float x1, float y2);
    public abstract boolean isThisButtonMove(float x1, float y1, float x2, float y2);
    public abstract void onDrawClicl(Canvas canvas);
}
