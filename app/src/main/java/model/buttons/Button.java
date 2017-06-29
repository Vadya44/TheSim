package model.buttons;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import model.scenes.Scene;

import model.DrawableElement;

/**
 * Created by Vadya on 25.06.17.
 */

public class Button extends DrawableElement implements IButton {
    private float x1, y1 ,x2, y2;
    private Paint realPaint;
    private boolean isBig = false;
    private Paint clickedPaint;
    private boolean wasClicked;
    private boolean isReal = false;
    private float factor;
    public Scene target;
    public void setBig(boolean isbig)
    {
        isBig = isbig;
    }
    public Button(float x1, float y1, float x2, float y2, float factor, boolean isReal, Scene target)
    {
        this.target = target;
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.factor = factor;
        this.isReal = isReal;
        initPaints();
    }
    public void setWasClicked(boolean wasClicked)
    {
        this.wasClicked = wasClicked;
    }
    private void initPaints()
    {
        clickedPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        float[] cmData = new float[]{
                1, 0, 0, 0, 0,
                0, 1, 0, 0, 0,
                0, 0, 1, 0, 0,
                0, 0, 0, 0.5f, 0};
        ColorMatrix cm = new ColorMatrix(cmData);
        ColorFilter filter = new ColorMatrixColorFilter(cm);
        clickedPaint.setColorFilter(filter);
        // TODO: Create real paint style
        realPaint = new Paint();
        wasClicked = false;

    }
    public Button()
    {
    }
    public boolean isThisButtonTap(float x, float y) {
        return  (x > x1 && x < x2 &&
                y < y2 && y > y1);
    }
    public boolean isThisButtonMove(float x1, float y1, float x2, float y2) {
        return  (x1 > this.x1 && x1 < this.x2 && x2 > this.x1 && x2 < this.x2 &&
                y1 > this.y1 && y1 < this.y2 && y2 > this.y1 && y2 < this.y2);
    }
    public void onDrawClick(Canvas canvas) {
        if (isBig) canvas.drawRoundRect(x1 * factor, y1 * factor, x2 * factor, y2 * factor, 50, 50, clickedPaint);
        else canvas.drawRoundRect(x1 * factor, y1 * factor, x2 * factor, y2 * factor, 20, 20, clickedPaint);
    }
    public void onDrawReal(Canvas canvas)
    {
        // TODO: Create real paint drawing fuction
    }
    @Override
    public void onDraw(Canvas canvas) {
        if (isReal) onDrawReal(canvas);
        if (wasClicked) onDrawClick(canvas);
    }
}
