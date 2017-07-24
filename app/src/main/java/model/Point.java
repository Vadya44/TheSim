package model;

import android.graphics.*;
import android.support.annotation.NonNull;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;

import java.util.ArrayList;

import model.DrawableElement;
import model.buttons.Button;
import vadyaproduction.sim.GameView;

/**
 * Created by Vadya on 02.07.17.
 */

public class Point extends DrawableElement implements Comparable<Point> {
    private boolean used;
    private int x;
    private int y;
    private Paint paint;
    public int getX()
    {
        return x;
    }
    public void setX(int x){
        this.x = x;
    }
    public int getY()
    {
        return y;
    }
    public void setY(int y){
        this.y = y;
    }
    public boolean getUsed()
    {
        return used;
    }
    public void setUsed(boolean user)
    {
        this.used = used;
    }
    public Point(int px, int py)
    {
        x = px;
        y = py;
        this.used = false;
        initPaint();
    }

    public void initPaint()
    {
        paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(2);
    }

    @Override
    public void onDraw(Canvas canvas) {
        canvas.drawCircle(x * GameView.factor, y * GameView.factor, 720 / 50 * GameView.factor, paint);
    }

    @Override
    public int compareTo(@NonNull Point point) {
        if (this.getX() == point.getX() && this.getY() == point.getY())
            return 0;
        else return -1;
    }
}
