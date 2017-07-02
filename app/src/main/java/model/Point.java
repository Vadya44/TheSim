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
    private Color color;
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
    public Color getColor()
    {
        return color;
    }
    public void setColor(Color color) {
        this.color = color;
    }
    public Point(int px, int py, Color color)
    {
        x = px;
        y = py;
        this.color = color;
        this.used = false;
        initPaint();
    }

    public void initPaint()
    {
        paint = new Paint();
    }
    @Override
    public void onDraw(Canvas canvas) {

    }

    @Override
    public int compareTo(@NonNull Point point) {
        if (this.getX() == point.getX() && this.getY() == point.getY())
            return 0;
        else return -1;
    }
}
