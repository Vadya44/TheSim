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
        _points = 
    }
}
