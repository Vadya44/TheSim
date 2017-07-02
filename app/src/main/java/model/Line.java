package model;

import android.graphics.*;
import android.support.annotation.NonNull;

import java.util.Comparator;

/**
 * Created by Vadya on 02.07.17.
 */

public class Line extends DrawableElement implements Comparable<Line> {
    private Point point1;
    private Point point2;
    Paint p;
    public Line(Point p1, Point p2) {
        point1 = p1;
        point2 = p2;
        initPaint();
    }
    public void setPoint1(Point point1)
    {
        this.point1 = point1;
    }
    public Point getPoint1()
    {
        return point1;
    }
    public void setPoint2(Point point2)
    {
        this.point2 = point2;
    }
    public Point getPoint2() {
        return point2;
    }
    @Override
    public void onDraw(Canvas canvas) {
    }
    public  void initPaint()
    {
        p = new Paint();
    }
    @Override
    public int compareTo(@NonNull Line line) {
        if (line.point1 == this.point1 && line.point2 == this.point2)
            return 0;
        else return -1;
    }
}
