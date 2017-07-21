package model;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by Vadya on 02.07.17.
 */

public class Circle extends DrawableElement {
    private int x;
    private int y;
    private double radius;
    private Paint p;
    public double Radius() {
        return  radius;
    }
    public int X(){
        return x;
    }
    public int Y()
    {
        return  y;
    }
    public Circle()
    {
        x = 720 / 2;
        y = 1280 / 2;
        radius = 360 - (int)(720 * 0.06);
        p = new Paint();
    }

    @Override
    public void onDraw(Canvas canvas) {
        //canvas.DrawCircle(_x * GameView.Factor,
          //      _y * GameView.Factor, Radius * GameView.Factor, p);
    }
}
