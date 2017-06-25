package model.buttons;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;

import model.DrawableElement;

/**
 * Created by Vadya on 25.06.17.
 */

public class Button extends DrawableElement implements IButton {
    float x1, y1 ,x2, y2;
    Paint p;
    private float factor;
    public Button(float x1, float y1, float x2, float y2, float factor)
    {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.factor = factor;
        p = new Paint(Paint.ANTI_ALIAS_FLAG);
        float[] cmData = new float[]{
                1, 0, 0, 0, 0,
                0, 1, 0, 0, 0,
                0, 0, 1, 0, 0,
                0, 0, 0, 0.5f, 0};
        ColorMatrix cm = new ColorMatrix(cmData);
        ColorFilter filter = new ColorMatrixColorFilter(cm);
        p.setColorFilter(filter);

    }
    public Button()
    {

    }
    public boolean isThisButtonTap(float x, float y) {
        if (x > x1 && x < x2 &&
                y < y2 && y > y1)
        {
            return  true;
        }
        else  return false;
    }
    public boolean isThisButtonMove(float x1, float y1, float x2, float y2) {
        if (x1 > this.x1 && x1 < this.x2 && x2 > this.x1 && x2 < this.x2 &&
                y1 > this.y1 && y1 < this.y2 && y2 > this.y1 && y2 < this.y2)

            return  true;
        else  return false;
    }

    @Override
    public void onDrawClick(Canvas canvas) {
        canvas.drawCircle(x1 * factor/2, y1 * factor/2, 100, p);
    }

    @Override
    public void onDraw(Canvas canvas) {
    }
}
