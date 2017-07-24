package model;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import vadyaproduction.sim.GameView;

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
        p.setStyle(Paint.Style.STROKE);
        p.setAntiAlias(true);
        p.setColor(Color.BLACK);
        p.setStrokeWidth(2);

    }

    @Override
    public void onDraw(Canvas canvas) {
        canvas.drawCircle(x * GameView.factor, y * GameView.factor, (float)radius * GameView.factor, p);
    }
}
