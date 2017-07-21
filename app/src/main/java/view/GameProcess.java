package view;

import model.Circle;
import model.Line;
import model.Point;
import model.scenes.Scene;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

import model.DrawableElement;
import model.buttons.Button;
import vadyaproduction.sim.GameView;

/**
 * Created by Vadya on 01.07.17.
 */

public final class GameProcess extends Scene {

    private int _ind1, _ind2, _ind3;
    private boolean _endGameFlag = false;
    private boolean _blockFlag = false;
    public Timer aTimer = new Timer();
    private ArrayList<Line> _plLines;
    private ArrayList<Line> _botLines;
    private ArrayList<Line> _usedLines;
    private ArrayList<Point> _points;
    public static GameProcess instance;
    private int counter;


    public GameProcess(GameView view, int counter)
    {
        this.view = view;
        this.counter = counter;
        _plLines = new ArrayList<Line>();
        _botLines = new ArrayList<Line>();
        _usedLines = new ArrayList<Line>();
        _points = new ArrayList<Point>();
        Circle circle = new Circle();
        _points =  CreatePoints(this.counter, circle, 720);
    }





    public static ArrayList<Point> CreatePoints(int number, Circle circle, int px)
    {
        Point[] _arr = new Point[number];
        for (int i = 0, alpha = 0; i < number; i++)
        {
            alpha += 360 / number;
            int rx = circle.X() - circle.X();
            int ry = circle.Y() + circle.Radius - circle.Y();
            double c = Math.Cos(Methods.DegreeToRadian(alpha));
            double s = Math.Sin(Methods.DegreeToRadian(alpha));
            int x1 = (int)(circle.X + rx * c - ry * s);
            int y1 = (int)(circle.Y + rx * s + ry * c);
            _arr[i] = new Point(x1, y1, clr);
        }
        return _arr;
    }
}
