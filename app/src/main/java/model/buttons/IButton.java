package model.buttons;

import android.graphics.Canvas;

/**
 * Created by Vadya on 25.06.17.
 */

public interface IButton {
    public boolean isThisButtonTap(float x, float y);
    public boolean isThisButtonMove(float x1, float y1, float x2, float y2);
    public void onDrawClick(Canvas canvas);
    
}
