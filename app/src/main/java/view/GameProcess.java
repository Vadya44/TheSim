package view;

import model.scenes.Scene;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;

import java.util.ArrayList;

import model.DrawableElement;
import model.buttons.Button;
import vadyaproduction.sim.GameView;

/**
 * Created by Vadya on 01.07.17.
 */

public final class GameProcess extends Scene {
    public static GameProcess instance;
    private int counter;
    public GameProcess(GameView view, int counter)
    {
        this.view = view;
        this.counter = counter;
    }
}
