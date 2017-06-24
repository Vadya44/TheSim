package model.scenes.buttons;

import android.graphics.*;

/**
 * Created by Vadya on 25.06.17.
 */

public final class AboutButton extends IButton {
    Paint p;
    public AboutButton(float x1, float y1, float x2, float y2)
    {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }
    @Override
    public boolean isThisButtonTap(float x, float y) {
        if (x > x1 && x < x2 &&
                y < y2 && y > y1)
        {
            p = new Paint();
            p.setAlpha(200);
            p.setColor(Color.BLACK);
            p.setStyle(Paint.Style.FILL);
            return  true;
        }
        else  return false;
    }
    @Override
    public boolean isThisButtonMove(float x1, float y1, float x2, float y2) {
        if (x1 > this.x1 && x1 < this.x2 && x2 > this.x1 && x2 < this.x2 &&
                y1 > this.y1 && y1 < this.y2 && y2 > this.y1 && y2 < this.y2)

            return  true;
        else  return false;
    }

    @Override
    public void onDrawClicl(Canvas canvas) {
        canvas.drawRect(x1,y1,x2,y2,p);
    }
}
